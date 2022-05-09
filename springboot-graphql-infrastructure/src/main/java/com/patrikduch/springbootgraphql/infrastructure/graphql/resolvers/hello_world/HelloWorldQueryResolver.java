package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.hello_world;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.MessageDto;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Test GraphQL data resolver for hello world queries.
 * @author Patrik Duch
 */
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    /**
     * Hello world query data resolver for displaying example sequence of characters.
     * @return Sequence of characters
     */
    public String helloWorld() {
        return "Hello World!";
    }

    /**
     * Parameterized example GraphQL query.
     * @param firstName First argument for passing first name
     * @param secondName Second argument for passing surname
     * @return Concatenation of firstName and secondName.
     */
    public String geetingMessage(String firstName, String secondName) {
        return firstName + " "  + secondName;
    }

    /**
     * Example GraphQL query, which return POJO class.
     * @return
     */
    public MessageDto getCustomMessage() {

        var res = new MessageDto();
        res.setId(UUID.randomUUID());
        res.setText("test");

        return res;
    }

    /**
     * Example GraphQL, which return list of integers.
     * @return List of integers.
     */
    public List<Integer> getRolDice() {
        return Arrays.asList(1,2,3,4);
    }
}
