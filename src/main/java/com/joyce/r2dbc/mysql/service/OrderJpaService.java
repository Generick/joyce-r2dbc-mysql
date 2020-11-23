package com.joyce.r2dbc.mysql.service;

import com.joyce.r2dbc.mysql.dao_jpa.OrderJpaRepository;
import com.joyce.r2dbc.mysql.model.OrderModel;
import com.joyce.r2dbc.mysql.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/23
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderJpaService {

    private OrderJpaRepository orderJpaRepository;

    // paging and sorting
    public Page<OrderModel> pagingAndSortingUserModel(Integer page, Integer size) {
        Pageable pageble = PageRequest.of(page, size, Sort.by("userId"));
        return orderJpaRepository.findAll(pageble);
    }

}
