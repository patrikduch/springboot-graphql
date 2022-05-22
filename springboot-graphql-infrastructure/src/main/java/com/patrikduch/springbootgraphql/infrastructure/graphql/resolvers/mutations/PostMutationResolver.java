package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.patrikduch.domain.dtos.app.post.PostItemDto;
import java.util.UUID;

/**
 * Mutation for altering state of Post entity.
 * @author Patrik Duch
 */
public class PostMutationResolver implements GraphQLMutationResolver {

    public UUID createPost (PostItemDto author) {
        return UUID.randomUUID();
    }
}
