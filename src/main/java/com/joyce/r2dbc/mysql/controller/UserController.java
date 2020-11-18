package com.joyce.r2dbc.mysql.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
@RestController
public class UserController {

    private DatabaseClient databaseClient;

    @RequestMapping("/user/saveOneRecord")
    public Mono<Void> get() {
        log.info("1111");
        return null;
    }

}
