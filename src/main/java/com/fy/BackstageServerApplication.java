package com.fy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //将服务注册到服务中心上
@SpringBootApplication
public class BackstageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackstageServerApplication.class, args);
	}

}
