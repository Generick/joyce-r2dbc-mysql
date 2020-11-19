package com.joyce.r2dbc.mysql.dao;

import com.joyce.r2dbc.mysql.model.UserModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
public interface UserRepository extends ReactiveCrudRepository<UserModel, Long> {

    @Query("select * from t_users where username = :username")
    Mono<UserModel> findByUsername(String username);
}
