package com.reader.interceptors;

import com.reader.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MainInterceptor implements HandlerInterceptor {

    @Autowired
    ApplicationContext context;

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("Pre handle");
//        var email = request.getHeader("Email");
//
//        if (email != null) {
//            ((AnnotationConfigServletWebServerApplicationContext) context).registerBean(User.class,email);
//        }
//
//        return true;
//    }
}
