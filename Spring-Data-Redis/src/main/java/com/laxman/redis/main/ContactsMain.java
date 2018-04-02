package com.laxman.redis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.laxman.redis")
public class ContactsMain {

	public static void main(String[] args) {
		SpringApplication.run(ContactsMain.class, args);

	}

}
