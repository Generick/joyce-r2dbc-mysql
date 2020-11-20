package com.joyce.r2dbc.mysql.util;

import com.joyce.r2dbc.mysql.dto.UserDto;
import io.r2dbc.spi.Row;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/20
 */
@Slf4j
@Component
@ReadingConverter
@WritingConverter
public class UserDtoReadingConverter implements Converter<Row, UserDto> {

    @Override
    public UserDto convert(Row row) {
        UserDto dto = UserDto.builder()
                .userId(row.get("user_id", Long.class))
                .username(row.get("username", String.class) + "0000")
                .birthdayDateTime(row.get("birthday_date_time", ZonedDateTime.class))
                .build();
        log.info("username =========== " + dto.getUsername());
        return dto;
    }
}
