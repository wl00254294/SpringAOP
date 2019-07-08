package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringAopApplication {

	public static void main(String[] args) {
		
		//System.out.println("2019-07-08") new branch;
		//fetch
		SpringApplication.run(SpringAopApplication.class, args);
	}

}
