package com.springtoy.toy.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class usersService implements UserDetailsService{

    @Autowired
    private sercurityUsersRepository SUrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        
        securityUsers users = SUrepo.findByUserid(username);

        
        List<GrantedAuthority> authorities = new ArrayList<>(); 
        System.out.println(users.getRoles().get(0));
        users.getRoles().forEach(e -> {
            authorities.add(new SimpleGrantedAuthority(e.getRole()));
        });
        // authorities.add(new SimpleGrantedAuthority("ROLE_BASE"));

        return new User(users.getUserid(), users.getUserpw(), authorities);

        // UserDetails userDetails = new UserDetails() {
        //     @Override
        //     public Collection<? extends GrantedAuthority> getAuthorities() {
        //         // TODO Auto-generated method stub
        //         List<GrantedAuthority> authorities = new ArrayList<>(); 
        //         authorities.add(new SimpleGrantedAuthority("ROLE_BASE"));
        //         return authorities;
        //     }

        //     @Override
        //     public String getPassword() {
        //         // TODO Auto-generated method stub
        //         return users.getUserpw();
        //     }

        //     @Override
        //     public String getUsername() {
        //         // TODO Auto-generated method stub
        //         return users.getUserid(); //유니크여야한다.
        //     }

        //     @Override
        //     public boolean isAccountNonExpired() {
        //         // TODO Auto-generated method stub
        //         return true;
        //     }

        //     @Override
        //     public boolean isAccountNonLocked() {
        //         // TODO Auto-generated method stub
        //         return true;
        //     }

        //     @Override
        //     public boolean isCredentialsNonExpired() {
        //         // TODO Auto-generated method stub
        //         return true;
        //     }
        //     @Override
        //     public boolean isEnabled() {
        //         // TODO Auto-generated method stub
        //         return true;
        //     }
        // };

        // return userDetails;
    }


    public securityUsers save(securityUsers users){
        users.setUserpw(passwordEncoder.encode(users.getUserpw()));
        return SUrepo.save(users);
    }
    
}
