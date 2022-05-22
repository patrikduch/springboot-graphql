package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.AuthorDto;
import com.patrikduch.domain.entities.AuthorEntity;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.AuthorFn;
import com.patrikduch.springbootgraphql.shared.utils.ModelMapperUtilImpl;
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

    @Override
    public AuthorDto fetchAuthorByPost(String warehouseId, String postId) {
        var entity = authorFn.fetchAuthorByPost(warehouseId, postId);
        var modelMapper = new ModelMapperUtilImpl<AuthorEntity, AuthorDto>(AuthorDto.class);

        var res = modelMapper.transformToDto(entity);

        return res;
    }
}
