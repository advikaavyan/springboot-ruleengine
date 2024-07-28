package com.example.poc.flow.config;

import javax.sql.DataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.integration.spring.SpringLiquibase;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/*@Configuration*/
public class TestLiquibaseConfig {

    /*@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }*/

  /*  @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog.xml");
        return liquibase;
    }*/
   /* @Bean
    public Liquibase truncateLiquibase(DataSource dataSource) throws Exception {
        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(dataSource.getConnection());
        return new Liquibase("classpath:/db/changelog/db.truncate.changelog.xml", resourceAccessor, database);
    }*/

   /* @Bean
    public Liquibase truncateLiquibase(DataSource dataSource) throws Exception {
        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        JdbcConnection jdbcConnection = new JdbcConnection(dataSource.getConnection());
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);
        return new Liquibase("classpath:/db/changelog/db.truncate.changelog.xml", resourceAccessor, database);
    }*/
   /* @Bean
    public Liquibase truncateLiquibase(DataSource dataSource) throws Exception {
        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        return new Liquibase("classpath:/db/changelog/db.truncate.changelog.xml", resourceAccessor, (DatabaseConnection) dataSource.getConnection());
    }*/
}
