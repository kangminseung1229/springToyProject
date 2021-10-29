package com.springtoy.toy.sample;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//jpaRepository 에 @repository가 들어 있기 때문에 아무 어노테이션을 사용하지 않고, DTO 에 는 @entity가 들어있어야한다.
//사용할 DTO class 와 그 PK를 적는다.
public interface sampleDataRepository extends JpaRepository<sampleData, Long> {

    // sampleData findById(Long id);        
    // Optional<sampleData> findById(Long id);        
    
}
