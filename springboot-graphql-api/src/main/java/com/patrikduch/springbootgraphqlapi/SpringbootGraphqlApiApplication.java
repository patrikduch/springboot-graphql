package com.patrikduch.springbootgraphqlapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry point for Springboot GraphQL application.
 * @author Patrik Duch
 */
@SpringBootApplication(scanBasePackages = {
        "com.patrikduch.springbootgraphqlapi",
        "com.patrikduch.springbootgraphql.core",
        "com.patrikduch.springbootgraphql.infrastructure",
        "com.patrikduch.springbootgraphql.local",
        "com.patrikduch.springbootgraphql.persistence",
})

// JPA
@EntityScan("com.patrikduch.springbootgraphql.persistence")
@EnableJpaRepositories("com.patrikduch.springbootgraphql.persistence")
public class SpringbootGraphqlApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraphqlApiApplication.class, args);
    }
}
