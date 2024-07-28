package com.example.poc.flow.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class AdaptorDataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.url}")
    private String url;


    @Bean
    public DataSource getDataSource() {
        log.info("=====driver============ {}", driver);
        log.info("=====url============ {}", url);
        log.info("=====username============ {}", username);
        log.info("=====password============ {}", password);
        return DataSourceBuilder.create()
                .driverClassName(driver)
                .username(username)
                .password(password)
                .url(url)
                .build();
    }
}
