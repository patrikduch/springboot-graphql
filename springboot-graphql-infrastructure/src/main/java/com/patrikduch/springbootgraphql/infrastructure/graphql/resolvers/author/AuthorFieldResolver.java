package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.app.author.AuthorItemDto;
import com.patrikduch.domain.dtos.app.post.PostItemDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import lombok.AllArgsConstructor;

/**
 * @class AuthorFieldResolver Resolver of Author field inside Post schema.
 * @author Patrik Duch
 */
@AllArgsConstructor
public class AuthorFieldResolver implements GraphQLResolver<PostItemDto> {

    private final AuthorDao authorDao;

    public AuthorItemDto author(PostItemDto postItemDto) {
        return authorDao.fetchAuthorByPost("4900", postItemDto.getId().toString());
    }
}
