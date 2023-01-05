package com.example.web.entity;


import com.example.web.dto.UserSaveDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private String userid;

    @Column
    private String userpw;

    @Column
    private int type;

    @Column
    private String username;

    @Column
    private String useremail;

    @Column
    private String phone;

    @Column
    private String option;

    @Column
    private String industry;

    @Column
    private String usercompany;

    public static User saveUser(UserSaveDTO userSaveDTO) {
        User user = new User();

        user.setUserid(userSaveDTO.getUserid());
        user.setUserpw(userSaveDTO.getUserpw());
        user.setUsername(userSaveDTO.getUsername());

        return user;
    }
}

