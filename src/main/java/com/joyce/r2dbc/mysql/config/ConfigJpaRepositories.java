package com.joyce.r2dbc.mysql.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
@EnableJpaRepositories("com.joyce.r2dbc.mysql.dao_jpa")
public class ConfigJpaRepositories {

    @Bean("dataSource")
    public DataSource dataSource(
            @Value("${spring.datasource.hikari.jdbc-url}") String jdbcUrl
            , @Value("${spring.datasource.hikari.username}") String username
            , @Value("${spring.datasource.hikari.password}") String password
            , @Value("${spring.datasource.hikari.driver-class-name}") String driverClassName
    ) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
        Map<String, Object> map = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        map.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return builder
                .dataSource(dataSource)
                .packages("com.joyce.r2dbc.mysql.model") // Entity class package name
                .properties(map)
                .persistenceUnit("myPersistenceUnit")
                .build();
    }


}
