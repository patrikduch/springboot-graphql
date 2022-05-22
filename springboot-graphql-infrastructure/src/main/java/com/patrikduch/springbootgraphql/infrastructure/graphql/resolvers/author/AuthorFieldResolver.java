package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import lombok.AllArgsConstructor;

/**
 * @class AuthorFieldResolver Resolver of Author field inside Post schema.
 * @author Patrik Duch
 */
@AllArgsConstructor
public class AuthorFieldResolver implements GraphQLResolver<PostDto> {

    private final AuthorDao authorDao;


    public AuthorDto author(PostDto postDto) {
        return authorDao.fetchAuthorByPost("4900", postDto.getId().toString());
    }
}
