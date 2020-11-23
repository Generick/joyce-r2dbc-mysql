package com.joyce.r2dbc.mysql.controller;

import com.joyce.r2dbc.mysql.dto.UserDto;
import com.joyce.r2dbc.mysql.model.OrderModel;
import com.joyce.r2dbc.mysql.service.OrderJpaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/23
 */
@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {

    private OrderJpaService orderJpaService;

    /*
    page zero-based
    http://localhost:8010/order/pagingAndSortingUserModel/0/2
     */
    @RequestMapping("/order/pagingAndSortingUserModel/{page}/{size}")
    public Page<OrderModel> pagingAndSortingUserModel(
            @PathVariable("page") Integer page
            , @PathVariable("size") Integer size
    ) {
        Page<OrderModel> user = orderJpaService.pagingAndSortingUserModel(page, size);
        return user;
    }

}
