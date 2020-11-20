package com.joyce.r2dbc.mysql.dao;

import com.joyce.r2dbc.mysql.dto.UserDto;
import com.joyce.r2dbc.mysql.model.UserModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
public interface UserRepository extends ReactiveCrudRepository<UserModel, Long> {

    @Query("select * from t_users where username = :username")
    Mono<UserModel> findByUsername(String username);

    @Query("select user_id, username, birthday_date_time from t_users where username = :username")
    Mono<UserDto> findByUsernameForDto(String username);

    @Query("select * from t_users where username = :username and age > :age")
    Mono<UserDto> findByUsernameAndAge(UserDto username);
}
