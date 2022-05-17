package com.patrikduch.springbootgraphql.persistence.seeders;

import com.patrikduch.domain.entities.ProjectDetailEntity;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.shared.constants.WarehouseConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * Seeder functionality for project-detail entity.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class ProjectDetailSeeder {

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
                "select COUNT(*) AS recordCount from springboot_graphql.projectdetail;",
                warehouseId
        );

        if (count == 0) {
            var projectDetail = new ProjectDetailEntity();
            projectDetail.setName("SpringBoot GraphQL");

            var sql = String.format(
                    "INSERT INTO springboot_graphql.projectdetail values ('%s', '%s');",
                    UUID.randomUUID(), projectDetail.getName()
            );

            genericRepository.add(sql, warehouseId);
        }
    }
}
