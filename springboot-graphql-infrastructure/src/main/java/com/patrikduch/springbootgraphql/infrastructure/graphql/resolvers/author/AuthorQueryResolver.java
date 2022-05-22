package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.app.author.AuthorListDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import lombok.AllArgsConstructor;

/**
 * @class Author data query resolver for fetching list of authors.
 * @author Patrik Duch
 */
@AllArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorDao authorDao;

    public AuthorListDto getAuthors(String warehouseId) {

        var test = authorDao.fetchAuthors(warehouseId);

        return authorDao.fetchAuthors(warehouseId);
    }
}
