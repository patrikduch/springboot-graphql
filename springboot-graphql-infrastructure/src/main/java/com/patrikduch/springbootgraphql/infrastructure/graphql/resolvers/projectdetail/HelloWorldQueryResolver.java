package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    public String helloWorld() {
        return "Hello World!";
    }
}
