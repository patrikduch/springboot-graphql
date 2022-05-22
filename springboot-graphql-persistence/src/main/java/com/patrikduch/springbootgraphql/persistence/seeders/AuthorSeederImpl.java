package com.patrikduch.springbootgraphql.persistence.seeders;

import com.patrikduch.domain.entities.AuthorEntity;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.shared.constants.WarehouseConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Seeder functional to fill some authors into "Author" relation entity.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class AuthorSeederImpl {

    private final GenericRepository genericRepository;

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
                "select COUNT(*) AS recordCount from springboot_graphql.author;",
                warehouseId
        );

        var authors = new ArrayList<AuthorEntity>();

        authors.add(AuthorEntity.builder()
                .id(UUID.randomUUID())
                .email("patrikduch@superemail.com")
                .name("Patrik")
                .build()
        );

        authors.add(AuthorEntity.builder()
                .id(UUID.randomUUID())
                .email("petradu@superemail.com")
                .name("Petra")
                .build());


        if (count == 0) {

            authors.forEach(c -> {

                var sql = String.format(
                        "INSERT INTO springboot_graphql.author values ('%s', '%s', '%s');",
                        UUID.randomUUID(), c.getName(), c.getEmail()
                );

                genericRepository.add(sql, warehouseId);
            });
        }
    }
}
