package com.patrikduch.springbootgraphql.core.interfaces.helpers;

import com.patrikduch.domain.dtos.shared.helpers.FunctionCallerDto;
import java.sql.SQLException;

/**
 * Contract that provides all necessary operations for all entitiy classes.
 * @author Patrik Duch
 */
public interface GenericRepository {
    Long count(String sql, String warehouseId);
    FunctionCallerDto callFn(String sql, String warehouseId) throws SQLException;
    void add(String sql, String warehouseId);
}
