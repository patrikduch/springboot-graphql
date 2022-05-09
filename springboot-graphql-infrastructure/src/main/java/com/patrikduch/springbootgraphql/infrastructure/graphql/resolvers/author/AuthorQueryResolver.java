package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.AuthorDto;

import java.util.List;
import java.util.UUID;

public class AuthorQueryResolver implements GraphQLQueryResolver {

    public List<AuthorDto> getAuthors() {
        return null;
    }
}
