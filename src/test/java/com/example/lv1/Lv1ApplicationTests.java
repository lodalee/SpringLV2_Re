package com.example.lv1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
class Lv1ApplicationTests {

	@Test
	void contextLoads() {
	}

}
