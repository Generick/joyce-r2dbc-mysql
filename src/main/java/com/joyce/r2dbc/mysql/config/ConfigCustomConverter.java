package com.joyce.r2dbc.mysql.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/20
 */
public class ConfigCustomConverter extends AbstractR2dbcConfiguration {
    @Override
    public ConnectionFactory connectionFactory() {
        return null;
    }
}
