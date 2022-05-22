package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.app.author.AuthorItemDto;
import com.patrikduch.domain.dtos.app.author.AuthorListDto;
import com.patrikduch.domain.entities.AuthorEntity;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.AuthorFn;
import com.patrikduch.springbootgraphql.shared.utils.ModelMapperUtilImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @class AuthorDao implementation for accessing author's data.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class AuthorDaoImpl implements AuthorDao {

    private final AuthorFn authorFn;

    @Override
    public AuthorListDto fetchAuthors(String warehouseId) {
        var entityList = authorFn.fetchAuthors(warehouseId);
        var modelMapper = new ModelMapperUtilImpl<AuthorEntity, AuthorItemDto>(AuthorItemDto.class);

        var authorItems = modelMapper.transformToDto(entityList);

        var authorList = AuthorListDto
                .builder()
                .collection(authorItems)
                .warehouseId(warehouseId)
                .build();

        return authorList;
    }

    @Override
    public AuthorItemDto fetchAuthorByPost(String warehouseId, String postId) {
        var entity = authorFn.fetchAuthorByPost(warehouseId, postId);
        var modelMapper = new ModelMapperUtilImpl<AuthorEntity, AuthorItemDto>(AuthorItemDto.class);

        var authorDto = modelMapper.transformToDto(entity);
        authorDto.setWarehouseId(warehouseId);

        return authorDto;
    }
}
