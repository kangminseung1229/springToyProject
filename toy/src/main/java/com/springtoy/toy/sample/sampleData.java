package com.springtoy.toy.sample;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class sampleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // database 에 생성 방식을 위임한다. autoincrement
    private Long id;
    private String title;
    private String memo;

    // 실제 컬럼이름에는 언더바가 있지만 JPA 네이밍에 의해 오류가 날 확률이 있어 자바에서는 다른 네이밍을 쓴다.
    @Column(name = "create_time")
    @CreationTimestamp
    private Date created;

    @Column(name = "update_time")
    @UpdateTimestamp
    private Date updated;

}
