package com.skumar.jenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDemoApplication {

	@GetMapping("/greetings/{name}")
	public String getGreetings(@PathVariable String name){
		return "Hello "+ name + " Welcome.";
	}


	public static void main(String[] args) {
		SpringApplication.run(JenkinsDemoApplication.class, args);
	}

}
