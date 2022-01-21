package com.guides.schedulling_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedullingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedullingTasksApplication.class, args);
	}

}
