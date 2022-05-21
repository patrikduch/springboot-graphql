package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.AuthorFn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @class AuthorDao implementation for accessing author's data.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class AuthorDaoImpl implements AuthorDao {

    private final AuthorFn authorFn;

    @Override
    public List<AuthorDto> fetchAuthors(String warehouseId) {
        return authorFn.fetchAuthors(warehouseId);
    }
}
