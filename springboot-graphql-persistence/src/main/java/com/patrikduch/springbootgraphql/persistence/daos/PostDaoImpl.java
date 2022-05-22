package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.domain.entities.PostEntity;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import com.patrikduch.springbootgraphql.shared.utils.ModelMapperUtilImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @class Data management for all Post entity operations.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class PostDaoImpl implements PostDao {

    private final PostFn postFn;

    @Override
    public List<PostDto> fetchPosts(String warehouseId) {
        var modelMapper = new ModelMapperUtilImpl<PostEntity, PostDto>(PostDto.class);
        return modelMapper.transformToDto(postFn.getPosts(warehouseId));
    }

    @Override
    public List<PostDto> fetchPostsByAuthorId(String warehouseId, String authorId) {
        var modelMapper = new ModelMapperUtilImpl<PostEntity, PostDto>(PostDto.class);
        return modelMapper.transformToDto(postFn.getPostsByAuthorId(warehouseId, authorId));
    }
}
