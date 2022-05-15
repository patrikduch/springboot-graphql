package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import java.util.List;

/**
 * @class AuthorDao implementation for accessing author's data.
 * @author Patrik Duch
 */
public class AuthorDaoImpl implements AuthorDao {

    @Override
    public List<AuthorDto> fetchAuthors() {
        return null;
    }
}
