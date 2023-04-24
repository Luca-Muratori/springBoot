package com.luca.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//in case we have important files in other folder, outside the springcoredemo folder we need to 
//identify them using scanBasePackages
// @SpringBootApplication(
// 	scanBasePackages = {"com.luca.springcoredemo ",
// 						"com.luca.util"} 
// )
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
