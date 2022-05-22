package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.app.post.PostItemDto;
import com.patrikduch.domain.dtos.app.post.PostListDto;
import com.patrikduch.domain.entities.PostEntity;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import com.patrikduch.springbootgraphql.core.interfaces.shared.utils.ModelMapperUtil;
import com.patrikduch.springbootgraphql.shared.utils.ModelMapperUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @class Data management for all Post entity operations.
 * @author Patrik Duch
 */
@Repository
public class PostDaoImpl implements PostDao {

    private final PostFn postFn;
    private ModelMapperUtil modelMapper;

    @Autowired
    public PostDaoImpl(PostFn postFn) {
        this.postFn = postFn;
        this.modelMapper = new ModelMapperUtilImpl<PostEntity, PostItemDto>(PostItemDto.class);
    }

    @Override
    public PostListDto fetchPosts(String warehouseId) {
        var postDtoList = modelMapper.transformToDto(postFn.getPosts(warehouseId));

        var resultList = new PostListDto();
        resultList.setCollection(postDtoList);
        resultList.setWarehouseId(warehouseId);

        return resultList;
    }

    @Override
    public PostListDto fetchPostsByAuthorId(String warehouseId, String authorId) {
        var postDtoList = modelMapper.transformToDto(postFn.getPostsByAuthorId(warehouseId, authorId));

        var resultList = new PostListDto();
        resultList.setCollection(postDtoList);
        resultList.setWarehouseId(warehouseId);

        return resultList;
    }
}
