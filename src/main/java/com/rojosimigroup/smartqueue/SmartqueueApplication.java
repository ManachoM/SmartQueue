package com.rojosimigroup.smartqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SmartqueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartqueueApplication.class, args);
	}

}
