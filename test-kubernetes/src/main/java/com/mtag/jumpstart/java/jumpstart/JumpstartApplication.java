package com.mtag.jumpstart.java.jumpstart;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JumpstartApplication {

	public static final UUID myID = UUID.randomUUID();


	public static void main(String[] args) {
		SpringApplication.run(JumpstartApplication.class, args);
	}


}
