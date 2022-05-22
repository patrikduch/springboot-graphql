package com.patrikduch.springbootgraphql.core.interfaces.daos;

import com.patrikduch.domain.dtos.app.post.PostListDto;


/**
 * @class DAO contract for acessing/manipulation with Post entity.
 * @author Patrik Duch
 */
public interface PostDao {
    PostListDto fetchPosts(String warehouseId);
    PostListDto fetchPostsByAuthorId(String warehouseId, String authorId);
}
