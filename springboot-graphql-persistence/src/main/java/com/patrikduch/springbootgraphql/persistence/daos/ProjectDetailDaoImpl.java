package com.patrikduch.springbootgraphql.persistence.daos;

import com.patrikduch.domain.dtos.ProjectDetailDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.ProjectDetailDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDetailDaoImpl implements ProjectDetailDao {

    @Override
    public ProjectDetailDto getProjectDetail() {
        var projectDetail = new ProjectDetailDto();
        projectDetail.setProjectName("Application name");
        return projectDetail;
    }
}
