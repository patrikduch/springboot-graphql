package com.patrikduch.springbootgraphql.persistence.helpers;

import com.patrikduch.domain.dtos.helpers.FunctionCallerDto;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.shared.constants.WarehouseConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Generic Repository, which encapsulates all data access logic for working with multiple-datasources via JDBC connector.
 * @author Patrik Duch
 */
@Repository
@RequiredArgsConstructor
public class GenericRepositoryImpl implements GenericRepository {

    private Connection connection;
    private final @Qualifier("jdbcTemplate1")
    JdbcTemplate jdbcTemplate1;
    private final @Qualifier("jdbcTemplate2")
    JdbcTemplate jdbcTemplate2;

    /**
     * Get number of record based on provided SQL and Db datasource.
     * @param sql  Query that will be triggered to fetch number of records.
     * @param warehouseId Warehouse id is used to determine, which datasource should be used,
     * @return Total rows count.
     */
    @Override
    public Long count(String sql, String warehouseId) {

        switch (warehouseId) {
            case WarehouseConstants.WAREHOUSE_ONE:
                return processCount(sql, jdbcTemplate1).getLong("recordCount");
            case WarehouseConstants.WAREHOUSE_TWO:
                return processCount(sql, jdbcTemplate2).getLong("recordCount");

            default:
                return 0L;
        }
    }

    /**
     * Get resultset of provided SQL PLPGSQL function.
     * @author Patrik Duch
     * @param warehouseId Warehouse id is used to determine, which datasource should be used.
     * @return Resultset of fetched data.
     */
    @Override
    public FunctionCallerDto callFn(String sql, String warehouseId) throws SQLException {
        this.connection = processMultipleDataSourceConnection(warehouseId);

        PreparedStatement pstmt = connection.prepareStatement(sql);
        return new FunctionCallerDto(pstmt, pstmt.executeQuery());
    }

    /**
     *
     * @author Patrik Duch
     * @param sql
     * @param jdbcTemplate
     * @return
     */
    private SqlRowSet processCount(String sql, JdbcTemplate jdbcTemplate) {
        var rowSet = jdbcTemplate.queryForRowSet(sql);
        rowSet.next();
        return rowSet;
    }

    /**
     * Process connection based by warehouseId.
     * @author Patrik Duch
     * @param  warehouseId Warehouse id is used to determine, which datasource should be used.
     * @return Connection object for accessing particular database.
     */
    private Connection processMultipleDataSourceConnection(String warehouseId) throws SQLException {
        switch (warehouseId) {
            case WarehouseConstants.WAREHOUSE_ONE:
                return connection = jdbcTemplate1.getDataSource().getConnection();
            case WarehouseConstants.WAREHOUSE_TWO:
                return connection = jdbcTemplate2.getDataSource().getConnection();
            default:
                return null;
        }
    }
}
