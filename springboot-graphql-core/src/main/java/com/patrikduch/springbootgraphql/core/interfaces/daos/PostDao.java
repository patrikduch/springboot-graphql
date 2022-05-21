package com.patrikduch.springbootgraphql.core.interfaces.daos;

import com.patrikduch.domain.dtos.PostDto;
import java.util.List;

/**
 * @class DAO contract for acessing/manipulation with Post entity.
 * @author Patrik Duch
 */
public interface PostDao {
    List<PostDto> fetchPosts(String warehouseId);
    List<PostDto> fetchPostsByAuthorId(String warehouseId, String authorId);
}
