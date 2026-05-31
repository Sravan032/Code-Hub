package com.sravan.Coding_Platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CodingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingPlatformApplication.class, args);
	}

}
