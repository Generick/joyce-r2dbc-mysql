package com.joyce.r2dbc.mysql.service;

import com.joyce.r2dbc.mysql.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@Service
@AllArgsConstructor
public class R2dbcEntityTemplateService {

    private R2dbcEntityTemplate r2dbcEntityTemplate;

    public static final String CREATE_TABLE_SQL = "CREATE TABLE `t_users_2`  ( " +
            "  `user_id` int(11) NOT NULL AUTO_INCREMENT, " +
            "  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL, " +
            "  `age` int(3) NOT NULL, " +
            "  `birthday_date_time` datetime(0) NOT NULL, " +
            "  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL, " +
            "  `create_date_time` datetime(0) NOT NULL, " +
            "   PRIMARY KEY (`user_id`) USING BTREE, " +
            "    UNIQUE KEY `unique_username2` (`username`) USING BTREE, " +
            "   KEY `idx_remark2` (`remark`) USING BTREE " +
            ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic";

    public Mono<Void> saveOneRecord() {
        r2dbcEntityTemplate.getDatabaseClient()
                .sql(CREATE_TABLE_SQL)
                .fetch()
                .rowsUpdated()
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete()
        ;

        r2dbcEntityTemplate.insert(UserModel.class)
                .using(UserModel.getNewInstance())
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete()
        ;

        r2dbcEntityTemplate.select(UserModel.class)
                .first()
                .doOnNext(model -> log.info(model.toString()))
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete()
        ;

        return null;
    }
}
