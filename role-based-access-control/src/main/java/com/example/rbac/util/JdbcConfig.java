package com.example.rbac.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.rbac.dao.impl.RoleDAOImpl;
import com.example.rbac.service.RoleService;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example.rbac")
public class JdbcConfig {

    // Define the DataSource bean
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // Change to your DB driver (e.g., MySQL, Postgres)
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres"); // DB URL
        dataSource.setUsername("postgres"); // DB Username
        dataSource.setPassword("Gagan@confluxsys"); // DB Password
        return dataSource;
    }

    // Define the JdbcTemplate bean, which uses the DataSource
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // Define RoleDAOImpl bean which uses JdbcTemplate
    @Bean
    public com.example.rbac.dao.impl.RoleDAOImpl roleDAO(JdbcTemplate jdbcTemplate) {
        return new com.example.rbac.dao.impl.RoleDAOImpl(jdbcTemplate);
    }

    // Define RoleService bean which uses RoleDAOImpl
    @Bean
    public com.example.rbac.service.RoleService roleService(@Qualifier("roleDAOImpl") RoleDAOImpl roleDAO) {
        return new RoleService(RoleDAOImpl);
    }

    // Similarly, define other beans for UserDAO and UserService if needed
}
