package com.patrikduch.springbootgraphql.persistence.seeders;

import com.patrikduch.domain.entities.ProjectDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class ProjectDetailSeeder {

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    public void init () {

        seedData(jdbcTemplate1);
        seedData(jdbcTemplate2);
    }


    private void seedData(JdbcTemplate jdbcTemplate) {
        var rowSet = jdbcTemplate.queryForRowSet("select count(*) from springboot_graphql.projectdetail;");

        if (rowSet.getRow() == 0) {

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
