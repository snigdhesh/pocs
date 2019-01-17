package com.example.mulitpledbdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.persistence.SecondaryTable;
import javax.sql.DataSource;

@Configuration
public class MultipleDataSourceConfiguration {

    @Bean(name = "h2")
    @ConfigurationProperties(prefix = "spring.h2.datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="h2Tx")
    public DataSourceTransactionManager h2Tx() {
        System.out.println("H2 Tx Manager creating...");
        return new DataSourceTransactionManager(secondaryDataSource());
    }

    @Bean(name = "mysql")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mysqlTx")
    //@Primary
    public DataSourceTransactionManager mysqlTx() {
        return new DataSourceTransactionManager(primaryDataSource());
    }


}