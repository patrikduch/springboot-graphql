package com.patrikduch.springbootgraphql.persistence.helpers;

import com.patrikduch.domain.dtos.helpers.FunctionCallerDto;
import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import com.patrikduch.springbootgraphql.shared.constants.WarehouseConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Generic Repository, which encapsulates all data access logic for working with multiple-datasources via JDBC connector.
 * @author Patrik Duch
 */
@Repository
public class GenericRepositoryImpl implements GenericRepository {

    private Connection connection;
    private final JdbcTemplate jdbcTemplate1;
    private final JdbcTemplate jdbcTemplate2;

    public GenericRepositoryImpl(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1, @Qualifier("jdbcTemplate2") JdbcTemplate jdbcTemplate2) {
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = jdbcTemplate2;
    }

    /**
     * Get number of record based on provided SQL and Db datasource.
     * @param sql  Query that will be triggered to fetch number of records.
     * @param warehouseId Warehouse id is used to determine, which datasource should be used,
     * @return Total rows count.
     */
    @Override
    public Long count(String sql, String warehouseId) {

        return switch (warehouseId) {
            case WarehouseConstants.WAREHOUSE_ONE -> processCount(sql, jdbcTemplate1).getLong("recordCount");
            case WarehouseConstants.WAREHOUSE_TWO -> processCount(sql, jdbcTemplate2).getLong("recordCount");
            default -> 0L;
        };
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

        return new FunctionCallerDto(connection, pstmt.executeQuery());
    }

    /**
     * Insert new row to the particular relation entity.
     * @param sql SQL query for inserting new row.
     * @param warehouseId Warehouse id is used to determine, which datasource should be used.
     */
    @Override
    public void add(String sql, String warehouseId) {

        switch (warehouseId) {
            case WarehouseConstants.WAREHOUSE_ONE -> jdbcTemplate1.execute(sql);
            case WarehouseConstants.WAREHOUSE_TWO -> jdbcTemplate2.execute(sql);
        }
    }

    /**
     * Process count query.
     * @author Patrik Duch
     * @param sql Query to fetch count value.
     * @param jdbcTemplate Access to particular database.
     * @return Instance of SqlRowSet.
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
        return switch (warehouseId) {
            case WarehouseConstants.WAREHOUSE_ONE -> connection = Objects.requireNonNull(jdbcTemplate1.getDataSource()).getConnection();
            case WarehouseConstants.WAREHOUSE_TWO -> connection = Objects.requireNonNull(jdbcTemplate2.getDataSource()).getConnection();
            default -> null;
        };
    }
}
