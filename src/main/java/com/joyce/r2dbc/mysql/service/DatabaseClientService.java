package com.joyce.r2dbc.mysql.service;

import lombok.AllArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DatabaseClientService {

    private DatabaseClient databaseClient;


}
