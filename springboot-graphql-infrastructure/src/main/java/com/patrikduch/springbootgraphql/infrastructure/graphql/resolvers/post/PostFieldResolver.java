package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.entities.PostEntity;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @class PostFieldResolver Data resolver for field property of class AuthorDto.
 * @author Patrik Duch
 */
public class PostFieldResolver implements GraphQLResolver<AuthorDto> {

    @Autowired
    private PostFn postFn;

    public List<PostEntity> posts(AuthorDto authorDto) {
        return postFn.getPostsByAuthorId(authorDto.getWarehouseId(), authorDto.getId().toString());
    }
}


