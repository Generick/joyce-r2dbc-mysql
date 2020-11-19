package com.joyce.r2dbc.mysql.controller;

import com.joyce.r2dbc.mysql.model.UserModel;
import com.joyce.r2dbc.mysql.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
@RestController
public class UserController {

    private UserService userService;

    @RequestMapping("/user/saveTwoRecord")
    public Mono<Tuple2<UserModel, UserModel>> saveTwoRecord() {
        return userService.saveTwoRecord().subscribeOn(Schedulers.boundedElastic());
    }

    @RequestMapping("/user/saveOneRecord")
    public Mono<UserModel> saveOneRecord() {
        return userService.saveOneRecord().subscribeOn(Schedulers.boundedElastic());
    }

    @RequestMapping("/user/findByUsername/{username}")
    public Mono<UserModel> findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username).subscribeOn(Schedulers.boundedElastic());
    }

}
