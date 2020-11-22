//package com.joyce.r2dbc.mysql.config;
//
//import com.joyce.r2dbc.mysql.util.LocalDateTimeToZonedDateTimeConverter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.support.GenericConversionService;
//import org.springframework.data.convert.CustomConversions;
//import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
//import org.springframework.data.r2dbc.dialect.DialectResolver;
//import org.springframework.data.r2dbc.dialect.R2dbcDialect;
//import org.springframework.r2dbc.core.DatabaseClient;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
//   don't delete this java class, datetime custom converter solution 1
// * @author: Joyce Zhu
// * @date: 2020/8/17
// */
//@Slf4j
//@Configuration
//public class ConfigConverter {
//
//    /*

//    refer spring source code: R2dbcDataAutoConfiguration.class -  public R2dbcCustomConversions r2dbcCustomConversions()
//     */
//    @Bean
////    @ConditionalOnMissingBean
//    public R2dbcCustomConversions getR2dbcCustomConversions(
//            @Autowired DatabaseClient databaseClient
//            , @Autowired LocalDateTimeToZonedDateTimeConverter timeConverter
//    ) {
//        R2dbcDialect dialect = DialectResolver.getDialect(databaseClient.getConnectionFactory());
//        List<Object> converters = new ArrayList<>(dialect.getConverters());
//        converters.addAll(R2dbcCustomConversions.STORE_CONVERTERS);
//
//        // add custom datetime converter
//        converters.add(timeConverter);
//
//        R2dbcCustomConversions customConversions = new R2dbcCustomConversions(
//                CustomConversions.StoreConversions.of(dialect.getSimpleTypeHolder(), converters),
//                Collections.emptyList());
//
//        return customConversions;
//    }
//}
