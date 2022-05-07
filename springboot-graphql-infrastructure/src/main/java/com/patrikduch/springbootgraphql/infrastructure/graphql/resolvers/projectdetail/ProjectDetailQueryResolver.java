package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.ProjectDetailDto;
import com.patrikduch.springbootgraphql.core.interfaces.daos.ProjectDetailDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectDetailQueryResolver implements GraphQLQueryResolver {

    @Autowired
    public ProjectDetailDao projectDetailDao;


    public ProjectDetailDto getProjectDetail() {
        return projectDetailDao.getProjectDetail();
    }
}
