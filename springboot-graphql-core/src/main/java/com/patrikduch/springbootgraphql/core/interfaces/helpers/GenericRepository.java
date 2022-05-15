package com.patrikduch.springbootgraphql.core.interfaces.helpers;

/**
 * Contract that provides all necessary operations for all entitiy classes.
 * @author Patrik Duch
 */
public interface GenericRepository {
    Long count(String sql, String warehouseId);
}
