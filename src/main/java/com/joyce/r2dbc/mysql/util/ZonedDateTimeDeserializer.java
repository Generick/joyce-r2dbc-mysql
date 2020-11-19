package com.joyce.r2dbc.mysql.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Joyce Zhu
 * @date: 2020/10/29
 */
public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return ZonedDateTime.parse(p.getText(), DateTimeFormatter.ofPattern(DatetimeConstant.yyyy_MM_dd_HH_mm_ss));
    }
}