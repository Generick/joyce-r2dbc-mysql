package com.joyce.r2dbc.mysql.dao;

import com.joyce.r2dbc.mysql.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserModel, Long> {
}
