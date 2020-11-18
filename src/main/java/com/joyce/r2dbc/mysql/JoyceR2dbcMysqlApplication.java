package com.joyce.r2dbc.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableR2dbcRepositories
@EnableWebFlux
public class JoyceR2dbcMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoyceR2dbcMysqlApplication.class, args);
	}

}
