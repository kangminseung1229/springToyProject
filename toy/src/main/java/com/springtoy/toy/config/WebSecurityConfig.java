package com.springtoy.toy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * WebSecurityConfig
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/login/**").permitAll()
                        .antMatchers("/login/register").permitAll()
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .usernameParameter("userid")
                        .passwordParameter("userpw")
                        .loginPage("/login")
                        .defaultSuccessUrl("/login/principal")
                        .failureHandler(new failHandler())
                        .permitAll()
                        .and()
                    .logout()
                        .logoutSuccessUrl("/?logout")
                        .permitAll()
                        .and()
                    .csrf().disable();
                    
    }
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    
}