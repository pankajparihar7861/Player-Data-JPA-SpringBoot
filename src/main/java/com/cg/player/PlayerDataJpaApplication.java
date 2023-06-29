package com.cg.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@OpenAPIDefinition
public class PlayerDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerDataJpaApplication.class, args);
	}

}
