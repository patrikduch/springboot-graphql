package com.patrikduch.springbootgraphql.core.interfaces.plpgsql.functions;

import com.patrikduch.domain.dtos.ProjectDetailDto;

/**
 * Contract for ProjectDetail SQL function caller.
 * @author Patrik Duch
 */
public interface ProjectDetailFn {
    ProjectDetailDto getProjectDetailFn(String sql, String warehouseId);
}
