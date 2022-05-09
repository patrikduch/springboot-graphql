package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.dtos.PostDto;

import java.util.List;

public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {

    public List<PostDto> getPost() {
        return null;
    }
}
