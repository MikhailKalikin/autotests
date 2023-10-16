package com.example.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EntityScan(basePackages = "com.example.lab")
@EnableJpaRepositories

public class Applicationlab {

    public static void main(String[] args) {
        SpringApplication.run(Applicationlab.class, args);
    }

}