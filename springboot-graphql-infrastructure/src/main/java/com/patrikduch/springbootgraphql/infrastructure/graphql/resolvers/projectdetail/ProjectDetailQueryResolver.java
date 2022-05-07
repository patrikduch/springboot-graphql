package com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.patrikduch.domain.dtos.ProjectDetailDto;

public class ProjectDetailQueryResolver implements GraphQLQueryResolver {

    public ProjectDetailDto getProjectDetail() {
        var test = new ProjectDetailDto();
        return test;
    }
}
