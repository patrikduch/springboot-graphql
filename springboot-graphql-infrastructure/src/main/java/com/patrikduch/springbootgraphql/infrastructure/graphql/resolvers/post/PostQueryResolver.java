package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.PostDto;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PostQueryResolver implements GraphQLQueryResolver {

    public List<PostDto> getPosts() {
        return Collections.singletonList(
                PostDto
                        .builder()
                        .category("test")
                        .description("test")
                        .title("aa")
                        .id(UUID.randomUUID())
                        .build());
    }
}
