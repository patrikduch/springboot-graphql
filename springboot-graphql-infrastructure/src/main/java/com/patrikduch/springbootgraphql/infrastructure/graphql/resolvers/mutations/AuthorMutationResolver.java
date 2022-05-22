package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.patrikduch.domain.dtos.app.author.AuthorItemDto;
import java.util.UUID;

/**
 * Mutation for altering state of Author entity.
 * @author Patrik Duch
 */
public class AuthorMutationResolver implements GraphQLMutationResolver {
    public UUID createAuthor (AuthorItemDto author) {
        return UUID.randomUUID();
    }
}
