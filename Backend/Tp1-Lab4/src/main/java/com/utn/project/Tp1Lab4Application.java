package com.utn.project;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.utn.project.dtos"}) //Esto es para que spring reconozca las carpetas de los dtos, entidades y repositroios mas rapido y seguro..
@EntityScan("com.utn.project.entities")
@EnableJpaRepositories("com.utn.project.repositories")
public class Tp1Lab4Application {

	public static void main(String[] args){
		SpringApplication.run(Tp1Lab4Application.class, args);
	}
	 
}
