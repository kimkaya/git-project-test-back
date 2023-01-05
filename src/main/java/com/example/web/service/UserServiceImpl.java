package com.example.web.service;

import com.example.web.dto.UserLoginDTO;
import com.example.web.dto.UserSaveDTO;
import com.example.web.entity.User;
import com.example.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // Repository 생성자 주입.
    private final UserRepository userRepository;

//    public void register(User us) throws Exception{
//        us.setType(1);
//        userRepository.save(us);
//
//    }
//
//    public void officeregister(User us) throws Exception{
//        us.setType(2);
//        userRepository.save(us);
//    }

    public Boolean checkDoubleId(String userid) throws Exception {
        Optional<User> ouser = userRepository.findByUserid(userid);
        if(ouser.isPresent()) return false;
        return true;
    }

    // 회원가입 정보 저장
    @Override
    public String register(UserSaveDTO userSaveDTO) {
        User user = User.saveUser(userSaveDTO);
        return userRepository.save(user).getUserid();
    }

    @Override
    public String officeregister(UserSaveDTO userSaveDTO) {
        User user = User.saveUser(userSaveDTO);
        return userRepository.save(user).getUserid();
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByUserid(userLoginDTO.getUserid()).get();
        if (user!=null) {
            if(user.getUserpw().equals(userLoginDTO.getUserpw())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}