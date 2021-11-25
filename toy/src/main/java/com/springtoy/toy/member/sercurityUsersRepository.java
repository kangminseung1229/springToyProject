package com.springtoy.toy.member;

import org.springframework.data.jpa.repository.JpaRepository;


public interface sercurityUsersRepository extends JpaRepository<securityUsers, Long>{

    
    //회원정보확인
    securityUsers findByUserid(String id);

}
