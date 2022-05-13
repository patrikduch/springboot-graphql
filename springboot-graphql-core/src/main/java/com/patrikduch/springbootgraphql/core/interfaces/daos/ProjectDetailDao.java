package com.patrikduch.springbootgraphql.core.interfaces.daos;

import com.patrikduch.domain.dtos.ProjectDetailDto;

public interface ProjectDetailDao {
    ProjectDetailDto getProjectDetail(String warehouseId);
    void changeProjectDetail(String projectName);
}
