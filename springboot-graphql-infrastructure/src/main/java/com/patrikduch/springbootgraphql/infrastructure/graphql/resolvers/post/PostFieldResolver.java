package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.app.author.AuthorItemDto;
import com.patrikduch.domain.dtos.app.post.PostListDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostFieldResolver implements GraphQLResolver<AuthorItemDto> {

    private final PostDao postDao;

    public PostListDto getPosts(AuthorItemDto authorDto) {
        return postDao.fetchPostsByAuthorId(
                authorDto.getWarehouseId(), authorDto.getId().toString()
        );
    }
}
