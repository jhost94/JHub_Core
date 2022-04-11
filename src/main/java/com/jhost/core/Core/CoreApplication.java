package com.jhost.core.Core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		//TODO: Set a service for profiles (dev, prod, qa, etc) and possible verifications
		SpringApplication.run(CoreApplication.class, args);
	}

}
