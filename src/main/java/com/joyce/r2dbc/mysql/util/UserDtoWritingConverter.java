//package com.joyce.r2dbc.mysql.util;
//
//import com.joyce.r2dbc.mysql.dto.UserDto;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.WritingConverter;
//import org.springframework.data.r2dbc.mapping.OutboundRow;
//import org.springframework.data.r2dbc.mapping.SettableValue;
//
///**
// * @author: Joyce Zhu
// * @date: 2020/11/20
// */
//@WritingConverter
//public class UserDtoWritingConverter implements Converter<UserDto, OutboundRow> {
//    @Override
//    public OutboundRow convert(UserDto source) {
//        OutboundRow row = new OutboundRow();
//        row.put("id", SettableValue.from(source.getId()));
//        row.put("name", SettableValue.from(source.getFirstName()));
//        row.put("age", SettableValue.from(source.getAge()));
//        return row;
//    }
//}
