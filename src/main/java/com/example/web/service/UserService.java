package com.example.web.service;

import com.example.web.dto.UserLoginDTO;
import com.example.web.dto.UserSaveDTO;

public interface UserService {
    String register(UserSaveDTO userSaveDTO);

    String officeregister(UserSaveDTO userSaveDTO);

    boolean login(UserLoginDTO userLoginDTO);
}
