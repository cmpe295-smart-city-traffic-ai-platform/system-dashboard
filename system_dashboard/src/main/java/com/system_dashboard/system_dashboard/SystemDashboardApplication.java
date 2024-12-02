package com.system_dashboard.system_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemDashboardApplication.class, args);
	}

}
