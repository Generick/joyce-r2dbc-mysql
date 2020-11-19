//package com.joyce.r2dbc.mysql.config;
//
//import com.disney.wdpro.service.ecoupon.redemption.service.util.StringToZonedDateTimeConverter;
//import com.joyce.r2dbc.mysql.util.LocalDateTimeToZonedDateTimeConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.support.GenericConversionService;
//import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//
//import javax.annotation.PostConstruct;
//import java.util.Objects;
//
///**
// * @author: Joyce Zhu
// * @date: 2020/8/17
// */
//@Configuration
//public class ConfigConverter {
//
//    @Autowired
//    private RequestMappingHandlerAdapter handlerAdapter;
//
//    @Autowired
//    LocalDateTimeToZonedDateTimeConverter localDateTimeToZonedDateTimeConverter;
//
//    @PostConstruct
//    public void getConfigurableWebBindingInitializer() {
//        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
//        if (Objects.nonNull(initializer)) {
//            ((GenericConversionService) initializer.getConversionService())
//                    .addConverter(stringToZonedDateTimeConverter);
//        }
//    }
//}
