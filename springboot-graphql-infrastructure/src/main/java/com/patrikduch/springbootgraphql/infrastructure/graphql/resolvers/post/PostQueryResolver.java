package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PostQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PostDao postDao;

    public List<PostDto> getPosts(String warehouseId) {

        return postDao.fetchPosts(warehouseId);
    }
}
