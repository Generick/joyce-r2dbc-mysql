package com.joyce.r2dbc.mysql.service;

import com.joyce.r2dbc.mysql.dao.UserRepository;
import com.joyce.r2dbc.mysql.dto.UserDto;
import com.joyce.r2dbc.mysql.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

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
        return userRepository.save(UserModel.getNewInstance());
    }

    @Transactional
    public Mono<Tuple2<UserModel, UserModel>> saveTwoRecord() {
        return userRepository.save(UserModel.getNewInstance())
                .zipWhen(userModel -> userRepository.save(UserModel.getNewInstance()))
                .doOnError(e -> {
                    log.error(e.getMessage(), e);
                })
                ;

    }

    public Mono<UserModel> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<UserDto> findByUsernameForDto(String username) {
        return userRepository.findByUsernameForDto(username);
    }

    public Mono<UserDto> findByUsernameAndAge(String username, Integer age) {
        UserDto dto = UserDto.builder()
                .age(age)
                .username(username)
                .build();
        return userRepository.findByUsernameAndAge(dto);
    }
}
