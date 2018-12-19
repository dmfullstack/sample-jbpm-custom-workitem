package com.company.workflowservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.company.workflowservice"})
@EnableMongoRepositories({"com.company.workflowservice.data.mongo"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}