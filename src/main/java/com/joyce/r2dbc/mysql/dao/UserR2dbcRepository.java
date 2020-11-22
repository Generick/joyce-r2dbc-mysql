package com.joyce.r2dbc.mysql.dao;

import com.joyce.r2dbc.mysql.dto.UserDto;
import com.joyce.r2dbc.mysql.model.UserModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
public interface UserR2dbcRepository extends R2dbcRepository<UserModel, Long> {

    @Query("select * from t_users where username = :username")
    Mono<UserModel> findByUsername(String username);

    @Query("select user_id, username, birthday_date_time from t_users where username = :username")
    Mono<UserDto> findByUsernameForDto(String username);

    // 尚未实验成功
    @Query("select * from t_users where username = :username and age > :age")
    Mono<UserDto> findByUsernameAndAge(UserDto username);
}
