package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @class AuthorQueryResolver
 * @author  Patrik Duch
 */
public class AuthorQueryResolver implements GraphQLQueryResolver {

    public List<AuthorDto> getAuthors() {
        return Collections.singletonList(AuthorDto
                .builder()
                .id(UUID.randomUUID())
                .email("testemail@gmail.com")
                .name("test").build());

    }
}
