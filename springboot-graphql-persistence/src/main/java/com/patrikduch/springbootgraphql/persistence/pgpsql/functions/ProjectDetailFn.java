package com.patrikduch.springbootgraphql.persistence.pgpsql.functions;

import com.patrikduch.domain.dtos.ProjectDetailDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Preparation of all project-detail retrieval PGpSQL functions.
 * @author Patrik Duch
 */
@Repository
public class ProjectDetailFn {

    /**
     * Get basic information about project.
     * @param jdbcTemplate Access to the particular SQL datasource.
     * @return ProjectDetail instance.
     */
    public ProjectDetailDto getProjectDetailFn(JdbcTemplate jdbcTemplate) {
        var projectdetail = new ProjectDetailDto();

        try {
            var conn = jdbcTemplate.getDataSource().getConnection();

            PreparedStatement pstmt = conn.prepareStatement("select * from springboot_graphql.get_projectdetail_fn()");

            ResultSet results = pstmt.executeQuery();
            while (results.next()) {  // do something with the results...
                projectdetail.setProjectName(results.getString("project_name"));
            }
            results.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectdetail;
    }
}
