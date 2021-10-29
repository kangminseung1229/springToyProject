package com.springtoy.toy.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // TODO Auto-generated method stub

        //view resolver를 통해 입력 URL -> maaping 된 html 실행
        // registry.addViewController("/login/regist").setViewName("login/totalLoginTest");
        // registry.addViewController("/").setViewName("/login");
        

    }

}
