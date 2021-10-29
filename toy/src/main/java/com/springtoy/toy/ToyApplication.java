package com.springtoy.toy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToyApplication {

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// 	return PasswordEncoderFactories.createDelegatingPasswordEncoder();  // 1
	// }
	public static void main(String[] args) {
		SpringApplication.run(ToyApplication.class, args);
	}


	
}
