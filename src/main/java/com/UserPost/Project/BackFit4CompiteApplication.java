package com.UserPost.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackFit4CompiteApplication {

	public static void main(String[] args) {
		String version = System.getProperty("java.version");
		System.out.println(">>>>>>>>>>>" + version);

		SpringApplication.run(BackFit4CompiteApplication.class, args);
	}

}
