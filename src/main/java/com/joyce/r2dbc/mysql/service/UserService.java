package com.joyce.r2dbc.mysql.service;

import com.joyce.r2dbc.mysql.dao.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
@Service
@AllArgsConstructor
public class UserService {

    private R2dbcEntityTemplate r2dbcEntityTemplate;
    private DatabaseClient databaseClient;
//    private UserRepository userRepository;

    public Mono<Void> saveOneRecord() {
//        template.getDatabaseClient().sql("CREATE TABLE person" +
//                "(id VARCHAR(255) PRIMARY KEY," +
//                "name VARCHAR(255)," +
//                "age INT)")
//                .fetch()
//                .rowsUpdated()
//                .as(StepVerifier::create)
//                .expectNextCount(1)
//                .verifyComplete();
//
//        template.insert(Person.class)
//                .using(new Person("joe", "Joe", 34))
//                .as(StepVerifier::create)
//                .expectNextCount(1)
//                .verifyComplete();
//
//        template.select(Person.class)
//                .first()
//                .doOnNext(it -> log.info(it))
//                .as(StepVerifier::create)
//                .expectNextCount(1)
//                .verifyComplete();
        return null;
    }
}
