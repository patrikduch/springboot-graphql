package com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions;

import com.patrikduch.domain.entities.PostEntity;
import java.util.List;

/**
 * Contract for all SQL functions associated with Post entity.
 * @author Patrik Duch
 */
public interface PostFn {
    List<PostEntity> getPosts(String warehouseId);
}
