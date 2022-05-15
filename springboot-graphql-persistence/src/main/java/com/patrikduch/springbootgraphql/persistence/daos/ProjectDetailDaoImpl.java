package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.ProjectDetailDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.ProjectDetailDao;
import com.patrikduch.springbootgraphql.persistence.pgpsql.functions.ProjectDetailFn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO for manipulation for ProjectDetail entity.
 * @author Patrik Duch
 */
@Repository
public class ProjectDetailDaoImpl implements ProjectDetailDao {

    private final JdbcTemplate jdbcTemplate1;
    private final JdbcTemplate jdbcTemplate2;
    private final ProjectDetailFn projectDetailFn;

    /**
     * Initializes a new instance of the ProjectDetailDaoImpl..
     * @param jdbcTemplate1 First SQL datasource.
     * @param jdbcTemplate2 Second  SQL datasource.
     */
    @Autowired
    public ProjectDetailDaoImpl(
            @Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1,
            @Qualifier("jdbcTemplate2") JdbcTemplate jdbcTemplate2,
            ProjectDetailFn projectDetailFn
    ) {
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = jdbcTemplate2;
        this.projectDetailFn = projectDetailFn;
    }

    /**
     * Get basic information about project.
     * @param warehouseId Identifier of particular warehouse.
     * @return Instance of ProjectDetailDto.
     */
    @Override
    public ProjectDetailDto getProjectDetail(String warehouseId) {

        var projectDetail = new ProjectDetailDto();

        if (warehouseId.equals("1")) {
            projectDetail = projectDetailFn.getProjectDetailFn(jdbcTemplate1);

        } else {
            projectDetail = projectDetailFn.getProjectDetailFn(jdbcTemplate2);
        }

        return projectDetail;
    }
}
