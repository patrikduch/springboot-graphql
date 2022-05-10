package com.patrikduch.springbootgraphql.core.interfaces.daos;

import com.patrikduch.domain.dtos.AuthorDto;
import java.util.List;

/**
 * @interface Contract for AuthorDao persistence logic.
 * @author Patrik Duch
 */
public interface AuthorDao {
    List<AuthorDto> fetchAuthors();
}
