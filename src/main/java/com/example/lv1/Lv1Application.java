package com.example.lv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // 시큐리티 기능 안씀
public class Lv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lv1Application.class, args);
	}

}
