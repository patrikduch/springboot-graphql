package com.patrikduch.domain.dtos.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Result of calling SQL function via JDBC connector.
 * @author Patrik Duch
 * @param <T1> Object of PreparedStatement for closing the particular connection in right time.
 * @param <T2> Resultset of SQL function.
 */
public class FunctionCallerDto<T1 extends Connection, T2 extends ResultSet> {
    private T1 f1;
    private T2 f2;
    public FunctionCallerDto(T1 f1, T2 f2) {
        this.f1 = f1; this.f2 = f2;
    }
    public T1 getF1() {return f1;}
    public T2 getF2() {return f2;}
}
