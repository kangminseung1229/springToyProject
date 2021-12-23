package com.springtoy.toy.sample;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class sampleDataValidator implements Validator {

    // lombok : RequiredArgsConstructor :: private final의 경우 생성자 생성, autowired 불필요
    private final sampleDataRepository sampleRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return clazz.isAssignableFrom(sampleData.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO
        sampleData sample = (sampleData) errors;

        if (sampleRepo.existsByTitle(sample.getTitle())) {
            errors.rejectValue("title", "invalid.title", new Object[] { sample.getTitle() }, "제목글자제한 8~200");

        }

    }

}
