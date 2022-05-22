package com.patrikduch.springbootgraphql.core.interfaces.daos;

import com.patrikduch.domain.dtos.app.author.AuthorItemDto;
import com.patrikduch.domain.dtos.app.author.AuthorListDto;

/**
 * @interface Contract for AuthorDao persistence logic.
 * @author Patrik Duch
 */
public interface AuthorDao {
    AuthorListDto fetchAuthors(String warehouseId);
    AuthorItemDto fetchAuthorByPost(String warehouse, String postId);
}
