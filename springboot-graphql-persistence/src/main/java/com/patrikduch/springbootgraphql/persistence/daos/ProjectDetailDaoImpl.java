package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.ProjectDetailDto;
import com.patrikduch.domain.entities.ProjectDetailEntity;
import com.patrikduch.springbootgraphql.core.interfaces.daos.ProjectDetailDao;
import com.patrikduch.springbootgraphql.persistence.mappers.ProjectDetailRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${shared.dbschema}")
    private String dbSchema;

    /**
     * Initializes a new instance of the ProjectDetailDaoImpl..
     * @param jdbcTemplate1 First SQL datasource.
     * @param jdbcTemplate2 Second  SQL datasource.
     */
    @Autowired
    public ProjectDetailDaoImpl(
            @Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1,
            @Qualifier("jdbcTemplate2") JdbcTemplate jdbcTemplate2
    ) {
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = jdbcTemplate2;
    }

    /**
     * Get basic information about project.
     * @param warehouseId Identifier of particular warehouse.
     * @return Instance of ProjectDetailDto.
     */
    @Override
    public ProjectDetailDto getProjectDetail(String warehouseId) {

        var projectDetail = new ProjectDetailDto();

        var sql = String.format("SELECT id, name from %s.projectdetail", dbSchema);

        ProjectDetailEntity result;
        if (warehouseId.equals("1")) {
            result = (ProjectDetailEntity) jdbcTemplate1
                    .query(sql, new ProjectDetailRowMapper())
                    .stream()
                    .findFirst().get();

        } else {
            result = (ProjectDetailEntity) jdbcTemplate2
                    .query(sql, new ProjectDetailRowMapper())
                    .stream()
                    .findFirst().get();

        }
        projectDetail.setProjectName(result.getName());

        return projectDetail;
    }
}
