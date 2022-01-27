package com.eterrain.yourbaazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class YourbaazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourbaazarApplication.class, args);
	}

}
