package com.springtoy.toy.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class failHandler implements AuthenticationFailureHandler {


    @Autowired
    private PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
    throws IOException, ServletException {
        // TODO Auto-generated method stub

        System.out.println("[예외발생]--------------------------------------------------------------------");
        System.out.println(exception);
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("[request]--------------------------------------------------------------------");
        System.out.println(request.getParameter("userid"));
        System.out.println(request.getParameter("userpw"));
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("[security Password]--------------------------------------------------------------------");
        System.out.println(pwEncoder.matches(request.getParameter("userpw"), "{bcrypt}$2a$10$J01U8irw7fdSWyrqb9mnqup5zj4TSFQT4xTnLz4kMe.iFzz7A51kO"));
        System.out.println();
        System.out.println();
        System.out.println();

        
        
        
        
    }

    


    

    

    
}
