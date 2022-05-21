package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class PostFieldResolver implements GraphQLResolver<AuthorDto> {

    private final PostDao postDao;

    public List<PostDto> getPosts(AuthorDto authorDto) {
        return postDao.fetchPostsByAuthorId(authorDto.getWarehouseId(), authorDto.getId().toString());
    }
}
