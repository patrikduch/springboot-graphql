package com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions;

import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.entities.AuthorEntity;
import java.util.List;

/**
 * Contract for all SQL functions associated with Author entity.
 * @author Patrik Duch
 */
public interface AuthorFn {
    List<AuthorDto> fetchAuthors(String warehouseId);
    AuthorEntity fetchAuthorByPost(String warehouseId, String postId);
}
