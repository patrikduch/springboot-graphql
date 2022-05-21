package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import lombok.AllArgsConstructor;
import java.util.List;

/**
 * @class Author data query resolver for fetching list of authors.
 * @author Patrik Duch
 */
@AllArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorDao authorDao;

    public List<AuthorDto> getAuthors(String warehouseId) {
        return authorDao.fetchAuthors(warehouseId);
    }
}
