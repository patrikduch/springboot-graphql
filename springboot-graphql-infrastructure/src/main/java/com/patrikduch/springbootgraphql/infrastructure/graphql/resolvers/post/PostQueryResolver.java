package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.entities.PostEntity;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PostQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PostFn postFn;

    public List<PostEntity> getPosts(String warehouseId) {
        return postFn.getPosts(warehouseId);
    }
}
