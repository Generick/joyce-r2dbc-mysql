package com.joyce.r2dbc.mysql.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.r2dbc.core.DatabaseClient;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@Configuration
@EnableJpaRepositories("com.joyce.r2dbc.mysql")
public class ConfigJpaRepositories {

//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//
//    }

//    @Autowired
//    private HikariDataSource hikariDataSource;

    public void tt() {
        log.info("123");
    }

    //主库连接工厂
//    @Bean("entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(
//            EntityManagerFactoryBuilder builder
//            , @Qualifier("dataSource") DataSource dataSource
//            , @Autowired HibernateProperties hibernateProperties
//            , @Autowired JpaProperties jpaProperties
//    ) {
//        Map<String, Object> map = hibernateProperties.determineHibernateProperties(
//                jpaProperties.getProperties(), new HibernateSettings());
//        map.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
//        return builder
//                .dataSource(dataSource)
//                .packages("com.joyce.r2dbc.mysql.model")//实体类包名
//                .properties(map)
//                .persistenceUnit("myPersistenceUnitName")
//                .build();
//    }

}
