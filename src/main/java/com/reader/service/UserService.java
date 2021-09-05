package com.reader.service;

import com.reader.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

/*
    TODO
     DI user service and write login and registration method , Hibernate , Spring Security
     userService.login(user);
     userService.registration(user);
*/

    public UserService(){}
//MOCK
    public User login(User user) {
        return new User();
    }

    public User registration(User user) {
        return this.login(user);
    }

}
