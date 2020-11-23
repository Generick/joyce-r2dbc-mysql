package com.joyce.r2dbc.mysql.dao_jpa;

import com.joyce.r2dbc.mysql.model.OrderModel;
import com.joyce.r2dbc.mysql.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderModel, Long> {
}
