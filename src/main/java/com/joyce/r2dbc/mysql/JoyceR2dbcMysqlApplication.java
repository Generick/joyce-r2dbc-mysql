package com.joyce.r2dbc.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableR2dbcRepositories
//@EnableJpaRepositories // support paging and sorting
//@EnableR2dbcAuditing // integration Spring Security
@EntityScan("com.joyce.r2dbc.mysql.model")
public class JoyceR2dbcMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoyceR2dbcMysqlApplication.class, args);
	}

}
