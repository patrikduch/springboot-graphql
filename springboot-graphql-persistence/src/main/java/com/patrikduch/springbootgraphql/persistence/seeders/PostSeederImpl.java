package com.patrikduch.springbootgraphql.persistence.seeders;

import com.patrikduch.domain.entities.PostEntity;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.AuthorFn;
import com.patrikduch.springbootgraphql.shared.constants.WarehouseConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class PostSeederImpl {
    private final GenericRepository genericRepository;
    private final AuthorFn authorFn;

    public void init () {
        seedData(WarehouseConstants.WAREHOUSE_ONE);
        seedData(WarehouseConstants.WAREHOUSE_TWO);
    }

    /**
     * Functionality for seeding ProjectDetail relations.
     * @author Patrik Duch
     */
    private void seedData(String warehouseId) {

        var count = genericRepository.count(
                "select COUNT(*) AS recordCount from springboot_graphql.post;",
                warehouseId
        );

        var authors = authorFn.fetchAuthors(warehouseId);

        var posts = new ArrayList<PostEntity>();

        posts.add(PostEntity.builder()
                .id(UUID.fromString(UUID.randomUUID().toString()))
                .title("POST #1")
                .description("Some test description for POST #1")
                .build());

        posts.add(PostEntity.builder()
                .id(UUID.fromString(UUID.randomUUID().toString()))
                .title("POST #2")
                .description("Some test description for POST #2")
                .build());


        posts.add(PostEntity.builder()
                .id(UUID.fromString(UUID.randomUUID().toString()))
                .title("POST #3")
                .description("Some test description for POST #3")
                .build());


        if (count == 0) {
            posts.forEach(p -> {
                var sql = String.format(
                        "INSERT INTO springboot_graphql.post values ('%s', '%s', '%s', '%s');",
                        UUID.randomUUID(), p.getTitle(), p.getDescription(), authors.get(0).getId()
                );

                genericRepository.add(sql, warehouseId);
            });
        }
    }
}
