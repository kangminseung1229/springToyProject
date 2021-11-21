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

    // @Autowired
    // private DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub

        http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/assets/**").permitAll()
                        .antMatchers("/img/**").permitAll()
                        .antMatchers("/*.css").permitAll()
                        .antMatchers("/login/**").permitAll()
                        .antMatchers("/login/register").permitAll()
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .usernameParameter("userid")
                        .passwordParameter("userpw")
                        .loginPage("/login")
                        .defaultSuccessUrl("/sample/list")
                        .failureHandler(new failHandler())
                        .permitAll()
                        .and()
                    .logout()
                        .permitAll()
                        .and()
                    .csrf().disable();
                    
    }


    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) 
    // throws Exception {
    //     auth.jdbcAuthentication()
    //     .dataSource(dataSource)
    //     .passwordEncoder(passwordEncoder())
    //     .usersByUsernameQuery("select userid as username, userpw as password, enabled "
    //                         +"from securityUsers "
    //                         +"where userid = ? ")
    //     .authoritiesByUsernameQuery("select user.userid as username, role.role as name from securityJoinTable jt "
    //     + "INNER JOIN securityUsers user on jt.userid = user.id "
    //     + "INNER JOIN securityRoles role on jt.roleid = role.id "
    //     + "where user.userid = ? "); 
        
    // }


    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    
}