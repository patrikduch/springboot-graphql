package com.patrikduch.springbootgraphql.local.setup;

import com.patrikduch.springbootgraphql.persistence.seeders.AuthorSeederImpl;
import com.patrikduch.springbootgraphql.persistence.seeders.ProjectDetailSeeder;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Definition of all operations that will be executed on SpringBoot startup within local environment.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Component
@Profile("local")
public class ApplicationStartupLocal implements ApplicationListener<ApplicationReadyEvent> {

    private final ProjectDetailSeeder projectDetailSeeder;
    private final AuthorSeederImpl  authorSeeder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        projectDetailSeeder.init();
        authorSeeder.init();
    }
}
