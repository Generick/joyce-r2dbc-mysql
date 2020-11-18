package com.joyce.r2dbc.mysql.dao;

import com.joyce.r2dbc.mysql.model.UserModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/18
 */
public interface UserRepository extends ReactiveCrudRepository<UserModel, Long> {
}
