package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.entities.AuthorEntity;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.AuthorFn;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @class AuthorQueryResolver
 * @author  Patrik Duch
 */
public class AuthorQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private AuthorFn authorFn;

    public List<AuthorDto> getAuthors(String warehouseId) {
        return authorFn.fetchAuthors(warehouseId);
    }
}
