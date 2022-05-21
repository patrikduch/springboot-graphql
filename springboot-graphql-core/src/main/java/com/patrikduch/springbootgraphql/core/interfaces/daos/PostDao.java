package com.patrikduch.springbootgraphql.core.interfaces.daos;

import com.patrikduch.domain.dtos.PostDto;
import java.util.List;

public interface PostDao {
    List<PostDto> fetchPosts(String warehouseId);
    List<PostDto> fetchPostsByAuthorId();
}
