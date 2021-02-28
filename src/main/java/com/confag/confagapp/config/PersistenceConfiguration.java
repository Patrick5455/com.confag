package com.confag.confagapp.config;

import lombok.val;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

@Configuration
public class PersistenceConfiguration {

    private final String dataSourceUrl = System.getenv("DB_URL");
    Properties properties = new Properties();
    private final String username = System.getenv("username");
    private final String password = System.getenv("password");
    @Bean //override jpa config of datasource
    public DataSource dataSource(){

        DataSourceBuilder dataSourceBuilder =
                DataSourceBuilder.create();

        dataSourceBuilder.url(dataSourceUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
