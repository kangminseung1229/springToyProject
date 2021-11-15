package com.springtoy.toy.login;

import com.springtoy.toy.member.securityRoles;
import com.springtoy.toy.member.securityUsers;
import com.springtoy.toy.member.sercurityUsersRepository;
import com.springtoy.toy.member.usersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/*
#로그인관련
#회원가입
*/
@Controller
@RequestMapping("/login")
public class loginController {

    @Autowired
    private sercurityUsersRepository SUrepo;

    @Autowired
    private PasswordEncoder pwEncoder;

    @Autowired
    private usersService usersService;

    
    // 회원가입페이지
    @GetMapping("register")
    public String register() {
        return "login/totalLoginTest";
    }

    // 회원가입액션
    @PostMapping("register")
    @ResponseBody
    public securityUsers registAction(@RequestParam(required = true) String registId,
            @RequestParam(required = true) String registPw) {

        try {
            securityUsers registUser = new securityUsers();
            // System.out.println("----------------------------------------------------------------------------");
            // System.out.println("[registPw]--->" + registPw);
            // System.out.println("[encoded]--->]" + pwEncoder.encode(registPw));
            // System.out.println("----------------------------------------------------------------------------");

            registUser.setEnabled(true);
            registUser.setUserid(registId);
            registUser.setUserpw(registPw);

            securityRoles roles = new securityRoles();
            roles.setId(1l);

            registUser.getRoles().add(roles);

            usersService.save(registUser); // service로 빼는 일이 많다.

            return SUrepo.findByUserid(registId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            securityUsers failuser = new securityUsers();
            failuser.setId(0l);

            return failuser;
        }

    }

    //스프링 시큐리티 비밀번호 일치 여부
    @PostMapping("compare")
    public String compare(@RequestParam String userid, @RequestParam String userpw) {
        //TODO: process POST request
        
        System.out.println(pwEncoder.matches(userpw, "{bcrypt}$2a$10$J01U8irw7fdSWyrqb9mnqup5zj4TSFQT4xTnLz4kMe.iFzz7A51kO"));
        
        return "complete";


    }

    //spring security principal
    @GetMapping("principal")
    public String principal(){
        return "login/loginPrincipal";
    }
    

}
