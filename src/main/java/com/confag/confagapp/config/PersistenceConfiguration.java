package com.confag.confagapp.config;

import lombok.val;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    private final String dataSourceUrl = System.getenv("DB_URL");
    private final String username = System.getenv("username");
    private final String password = System.getenv("password");
    @Bean //override jpa config of datasource
    public DataSource dataSource(){

        val dataSourceBuilder =
                DataSourceBuilder.create();

        dataSourceBuilder.url(dataSourceUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
