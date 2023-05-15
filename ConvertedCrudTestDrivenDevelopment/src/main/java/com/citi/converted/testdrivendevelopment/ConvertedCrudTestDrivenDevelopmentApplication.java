package com.citi.converted.testdrivendevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan
@ComponentScan({"com.citi.converted.testdrivendevelopment.controller",
	"com.citi.converted.testdrivendevelopment.serviceImpl",
	"com.citi.converted.testdrivendevelopment.entity",
	"com.citi.converted.testdrivendevelopment.Repository"})

public class ConvertedCrudTestDrivenDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertedCrudTestDrivenDevelopmentApplication.class, args);
	}

}
