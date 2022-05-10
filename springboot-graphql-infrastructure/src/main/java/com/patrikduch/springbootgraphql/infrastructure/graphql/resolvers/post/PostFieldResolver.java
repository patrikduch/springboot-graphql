package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.dtos.PostDto;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @class AuthorFieldResolver Data resolver for field property of class AuthorDto.
 * @author Patrik Duch
 */
public class PostFieldResolver implements GraphQLResolver<AuthorDto> {

    public List<PostDto> getPosts(AuthorDto authorDto) {
        return Collections.singletonList(
                PostDto
                        .builder()
                            .authorId(authorDto.getId())
                            .category("test")
                            .description("test")
                            .title("aa")
                            .id(UUID.randomUUID())
                        .build());

    }
}
