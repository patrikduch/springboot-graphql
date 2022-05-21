package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.dtos.PostDto;
import java.util.UUID;

/**
 * @class AuthorFieldResolver Resolver of Author field inside Post schema.
 * @author Patrik Duch
 */
public class AuthorFieldResolver implements GraphQLResolver<PostDto> {

    public AuthorDto author(PostDto postDto) {
        var author = new AuthorDto();
        author.setEmail("email@gmail.com");
        author.setId(UUID.randomUUID());
        author.setName("patrik");
        return author;
    }
}
