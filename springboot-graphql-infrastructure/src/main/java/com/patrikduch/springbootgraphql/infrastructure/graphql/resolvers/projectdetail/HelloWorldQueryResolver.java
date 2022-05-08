package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.MessageDto;
import java.util.UUID;

/**
 * Test GraphQL data resolver for hello world queries.
 * @author Patrik Duch
 */
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Hello World!";
    }

    public String geetingMessage(String firstName, String secondName) {
        return firstName + " "  + secondName;
    }

    public MessageDto getCustomMessage() {

        var res = new MessageDto();
        res.setId(UUID.randomUUID());
        res.setText("test");

        return res;
    }
}
