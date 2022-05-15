package com.patrikduch.springbootgraphql.persistence.helpers;

import com.patrikduch.springbootgraphql.core.interfaces.helpers.GenericRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

/**
 * Generic Repository, which encapsulates all data access logic for working with multiple-datasources via JDBC connector.
 * @author Patrik Duch
 */
@Repository
@AllArgsConstructor
public class GenericRepositoryImpl implements GenericRepository {

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
            case "4900":
                return processCount(sql, jdbcTemplate1).getLong("recordCount");
            case "4901":
                return processCount(sql, jdbcTemplate2).getLong("recordCount");

            default:
                return 0L;
        }
    }

    private SqlRowSet processCount(String sql, JdbcTemplate jdbcTemplate) {
        var rowSet = jdbcTemplate.queryForRowSet(sql);
        rowSet.next();
        return rowSet;
    }

}
