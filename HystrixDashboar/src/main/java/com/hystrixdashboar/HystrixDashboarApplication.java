package com.hystrixdashboar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboarApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboarApplication.class, args);
	}

}
