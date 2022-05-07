package com.patrikduch.springbootgraphqlapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Scanning all necessary packages
@SpringBootApplication(scanBasePackages = {
        "com.patrikduch.springbootgraphql.infrastructure",
        "com.patrikduch.springbootgraphql.core",
})
public class SpringbootGraphqlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraphqlApiApplication.class, args);
    }

}
