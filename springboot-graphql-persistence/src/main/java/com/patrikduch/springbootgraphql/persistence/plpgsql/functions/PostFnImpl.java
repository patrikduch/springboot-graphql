package com.patrikduch.springbootgraphql.persistence.plpgsql.functions;

import com.patrikduch.domain.entities.PostEntity;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.PostFn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class PostFnImpl implements PostFn {

    private final GenericRepository genericRepository;

    @Override
    public List<PostEntity> getPosts(String warehouseId) {
        var postList = new ArrayList<PostEntity>();
        var sql = "select * from springboot_graphql.get_posts_fn();";

        try {
            var results = genericRepository.callFn(sql, warehouseId);

            while (results.getF2().next()) {  // do something with the results...
                postList.add(PostEntity.builder()
                                .id(UUID.fromString(results.getF2().getString("id")))
                                .title(results.getF2().getString("title"))
                                .description(results.getF2().getString("description"))
                                .warehouseId(warehouseId)

                        .build());
            }



            results.getF2().close();
            results.getF1().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postList;
    }

    @Override
    public List<PostEntity> getPostsByAuthorId(String warehouseId, String authorId) {
        var postList = new ArrayList<PostEntity>();
        var sql = String.format("select * from springboot_graphql.get_author_posts_fn('%s');", authorId);

        try {
            var results = genericRepository.callFn(sql, warehouseId);

            while (results.getF2().next()) {  // do something with the results...
                postList.add(PostEntity.builder()
                        .id(UUID.fromString(results.getF2().getString("id")))
                        .title(results.getF2().getString("title"))
                        .description(results.getF2().getString("description"))
                        .build());
            }
            results.getF2().close();
            results.getF1().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postList;
    }
}
