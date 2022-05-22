package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.app.ProjectDetailDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.ProjectDetailDao;
import com.patrikduch.springbootgraphql.persistence.plpgsql.functions.ProjectDetailFnImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO for manipulation for ProjectDetail entity.
 * @author Patrik Duch
 */
@AllArgsConstructor
@Repository
public class ProjectDetailDaoImpl implements ProjectDetailDao {

    private final @Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1;
    private final @Qualifier("jdbcTemplate2") JdbcTemplate jdbcTemplate2;
    private final ProjectDetailFnImpl projectDetailFn;

    /**
     * Get basic information about project.
     * @param warehouseId Identifier of particular warehouse.
     * @return Instance of ProjectDetailDto.
     */
    @Override
    public ProjectDetailDto getProjectDetail(String warehouseId) {

        var projectDetail = projectDetailFn.getProjectDetailFn(
                "select * from springboot_graphql.get_projectdetail_fn()",
                warehouseId
        );

        return projectDetail;
    }
}
