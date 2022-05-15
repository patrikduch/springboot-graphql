package com.patrikduch.springbootgraphql.persistence.seeders;

import com.patrikduch.domain.entities.ProjectDetailEntity;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * Seeder functionality for project-detail entity.
 * @author Patrik Duch
 */
@Repository
public class ProjectDetailSeeder {

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    @Autowired
    private GenericRepository genericRepository;

    public void init () {
        seedData(jdbcTemplate1);
        seedData(jdbcTemplate2);
    }

    /**
     * Functionality for seeding ProjectDetail relations.
     * @author Patrik Duch
     * @param jdbcTemplate Access to the particular dataset.
     */
    private void seedData(JdbcTemplate jdbcTemplate) {

        var count = genericRepository.count(
                "select COUNT(*) AS recordCount from springboot_graphql.projectdetail;",
                "4900"
        );

        if (count == 0) {
            var projectDetail = new ProjectDetailEntity();
            projectDetail.setName("SpringBoot GraphQL");

            var sql = String.format(
                    "INSERT INTO springboot_graphql.projectdetail values ('%s', '%s');",
                    UUID.randomUUID(), projectDetail.getName()
            );

            jdbcTemplate.execute(sql);
        }
    }
}
