package com.reader.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MainInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(MainInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var origin = request.getHeader("Origin");
        logger.info("Request from : " + origin);
        logger.info("Request destination : " + request.getRequestURI());
        response.addHeader("Access-Control-Allow-Origin",origin);
        response.addHeader("Vary","Origin");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Response status : " + response.getStatus());
    }
}
