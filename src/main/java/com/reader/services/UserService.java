package com.reader.services;

import com.reader.models.User;
import org.springframework.context.annotation.Configuration;

@Configuration
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
        if (user.equals(new User("test@test","test")) && user.isTrusted()) {
            user.setPassword("******");
            return user;
        }
        return new User(null,null,false);
    }

    public User registration(User user) {
        return this.login(user);
    }

}
