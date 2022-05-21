package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.PostDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import com.patrikduch.springbootgraphql.persistence.modelmappers.PostModelMapper;
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
    private final PostModelMapper postModelMapper;

    @Override
    public List<PostDto> fetchPosts(String warehouseId) {
        return postModelMapper.transformPostList(postFn.getPosts(warehouseId));
    }

    @Override
    public List<PostDto> fetchPostsByAuthorId(String warehouseId, String authorId) {
        return postModelMapper.transformPostList(postFn.getPostsByAuthorId(warehouseId, authorId));
    }
}
