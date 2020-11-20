package com.joyce.r2dbc.mysql.service;

import lombok.AllArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

/*
refer https://docs.spring.io/spring-data/r2dbc/docs/1.2.1/reference/html/#upgrading.1.1-1.2
 */
@Service
@AllArgsConstructor
public class DatabaseClientService {

    /*
    Since Spring Data R2DBC 1.2.0 :
    Deprecate Spring Data R2DBC DatabaseClient and move off deprecated API in favor of Spring R2DBC

    springboot 2.4.0 with r2dbc 1.2.1
     */
    private DatabaseClient databaseClient;


}
