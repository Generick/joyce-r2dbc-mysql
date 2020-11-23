package com.joyce.r2dbc.mysql.controller;

import com.joyce.r2dbc.mysql.dto.UserDto;
import com.joyce.r2dbc.mysql.model.UserModel;
import com.joyce.r2dbc.mysql.service.UserR2dbcService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private UserR2dbcService userR2dbcService;

    @RequestMapping("/user/saveTwoRecord")
    public Mono<Tuple2<UserModel, UserModel>> saveTwoRecord() {
        return userR2dbcService.saveTwoRecord().subscribeOn(Schedulers.boundedElastic());
    }

    @RequestMapping("/user/saveOneRecord")
    public Mono<UserModel> saveOneRecord() {
        return userR2dbcService.saveOneRecord().subscribeOn(Schedulers.boundedElastic());
    }

    @RequestMapping("/user/findByUsername/{username}")
    public Mono<UserModel> findByUsername(@PathVariable("username") String username) {
        Mono<UserModel> user = userR2dbcService.findByUsername(username)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(userModel -> {
                    log.info("------------------------- username = {}, age = {}", userModel.getUsername(), userModel.getAge());
                })
                ;
        return user;
    }

    @RequestMapping("/user/findByUsernameForDto/{username}")
    public Mono<UserDto> findByUsernameForDto(@PathVariable("username") String username) {
        Mono<UserDto> user = userR2dbcService.findByUsernameForDto(username)
                .subscribeOn(Schedulers.boundedElastic())
                ;
        return user;
    }

    @RequestMapping("/user/findByUsernameAndAge/{username}/{age}")
    public Mono<UserDto> findByUsernameAndAge(
            @PathVariable("username") String username
            , @PathVariable("age") Integer age
    ) {
        Mono<UserDto> user = userR2dbcService.findByUsernameAndAge(username, age)
                .subscribeOn(Schedulers.boundedElastic())
                ;
        return user;
    }

//    @RequestMapping("/user/pagingAndSortingUserModel/{page}/{size}")
//    public Page<UserModel> pagingAndSortingUserModel(
//            @PathVariable("page") Integer page
//            , @PathVariable("size") Integer size
//    ) {
//        Page<UserModel> user = userService.pagingAndSortingUserModel(page, size);
//        return user;
//    }

}
