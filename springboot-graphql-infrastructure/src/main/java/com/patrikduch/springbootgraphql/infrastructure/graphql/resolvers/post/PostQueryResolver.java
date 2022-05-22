package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.app.post.PostListDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostDao postDao;

    @Autowired
    public PostQueryResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public PostListDto getPosts(String warehouseId) {

        //return postDao.fetchPosts(warehouseId);
        return postDao.fetchPosts(warehouseId);
    }
}
