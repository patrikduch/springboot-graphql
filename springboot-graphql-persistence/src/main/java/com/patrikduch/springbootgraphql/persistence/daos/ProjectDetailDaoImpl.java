package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.ProjectDetailDto;
import com.patrikduch.domain.entities.ProjectDetailEntity;
import com.patrikduch.springbootgraphql.core.interfaces.daos.ProjectDetailDao;
import com.patrikduch.springbootgraphql.persistence.mappers.CountRowMapper;
import com.patrikduch.springbootgraphql.persistence.mappers.ProjectDetailRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class ProjectDetailDaoImpl implements ProjectDetailDao {

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    @Override
    public ProjectDetailDto getProjectDetail(String warehouseId) {


        var projectDetail = new ProjectDetailDto();

        if (warehouseId.equals("1")) {
            var sql = "SELECT id, name from springboot_graphql.projectdetail";
            var result = (ProjectDetailEntity)jdbcTemplate1
                    .query(sql, new ProjectDetailRowMapper())
                    .stream()
                    .findFirst().get();

            projectDetail.setProjectName(result.getName());

        } else {
            var sql = "SELECT id, name from springboot_graphql.projectdetail";
            var result = (ProjectDetailEntity)jdbcTemplate2
                    .query(sql, new ProjectDetailRowMapper())
                    .stream()
                    .findFirst().get();

            projectDetail.setProjectName(result.getName());
        }



        return projectDetail;
    }

    @Override
    public void changeProjectDetail(@NotNull String projectName) {


    }
}
