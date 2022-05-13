package com.patrikduch.springbootgraphql.persistence.mappers;

import com.patrikduch.domain.entities.ProjectDetailEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDetailRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        var projectdetail = new ProjectDetailEntity();
        projectdetail.setId(rs.getString("id"));
        projectdetail.setName(rs.getString("name"));

        return projectdetail;
    }
}
