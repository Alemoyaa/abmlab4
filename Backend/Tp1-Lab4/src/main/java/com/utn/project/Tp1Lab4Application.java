package com.utn.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.utn.project.dtos"})
@EntityScan("com.utn.project.entities")
@EnableJpaRepositories("com.utn.project.repositories")
public class Tp1Lab4Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp1Lab4Application.class, args);
	}
	 
}
