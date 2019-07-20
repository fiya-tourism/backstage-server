package com.fy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BackstageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackstageServerApplication.class, args);
	}

}
