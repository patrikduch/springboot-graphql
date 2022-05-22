package com.patrikduch.springbootgraphql.persistence.plpgsql.functions;

import com.patrikduch.domain.dtos.app.ProjectDetailDto;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions.ProjectDetailFn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;

/**
 * Preparation of all project-detail retrieval PGpSQL functions.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class ProjectDetailFnImpl implements ProjectDetailFn {

    private final GenericRepository genericRepository;

    /**
     * Get basic information about project.
     * @return ProjectDetail instance.
     */
    public ProjectDetailDto getProjectDetailFn(String sql, String warehouseId) {
        var projectdetail = new ProjectDetailDto();

        try {
            var results = genericRepository.callFn(sql, warehouseId);

            while (results.getF2().next()) {  // do something with the results...
                projectdetail.setProjectName(results.getF2().getString("project_name"));
            }
            results.getF2().close();
            results.getF1().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectdetail;
    }
}
