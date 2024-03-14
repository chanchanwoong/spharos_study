package com.spharos.ssgdotcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SsgdotcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsgdotcomApplication.class, args);
	}

}
