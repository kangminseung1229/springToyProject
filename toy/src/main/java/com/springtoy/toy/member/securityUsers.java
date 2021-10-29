package com.springtoy.toy.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class securityUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String userpw;
    private boolean enabled;

    @ManyToMany
    @JoinTable(
        name = "securityJoinTable",
        joinColumns = @JoinColumn(name="userid"),
        inverseJoinColumns = @JoinColumn(name="roleid")
    )
    List<securityRoles> roles = new ArrayList<>();
    
}
