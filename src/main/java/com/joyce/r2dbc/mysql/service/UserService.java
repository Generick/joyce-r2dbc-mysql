package com.joyce.r2dbc.mysql.service;

import com.joyce.r2dbc.mysql.dao.UserRepository;
import com.joyce.r2dbc.mysql.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public Mono<UserModel> saveOneRecord() {
//        Mono<UserModel> user1 = userRepository.save(UserModel.getNewInstance());
        Mono<UserModel> user2 = userRepository.save(UserModel.getNewInstance());
        return user2;
    }
}
