package com.example.lab;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LiquibaseRunner implements CommandLineRunner {

    private final SpringLiquibase liquibase;

    @Autowired
    public LiquibaseRunner(SpringLiquibase liquibase) {
        this.liquibase = liquibase;
    }

    @Override
    public void run(String... args) throws Exception {
        liquibase.afterPropertiesSet();
    }
}