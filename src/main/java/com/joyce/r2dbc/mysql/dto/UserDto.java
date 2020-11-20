package com.joyce.r2dbc.mysql.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeDeserializer;
import com.joyce.r2dbc.mysql.util.ZonedDateTimeSerialize;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Converter;
import java.time.ZonedDateTime;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/20
 */
@Builder
@Data
@Converter
public class UserDto {

    private Long userId;

    private String username;

    private Integer age;

    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerialize.class)
    private ZonedDateTime birthdayDateTime;
}
