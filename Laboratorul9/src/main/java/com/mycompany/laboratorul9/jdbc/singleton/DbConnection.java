/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jdbc.singleton;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;

/**
 *
 * @author Radu
 */
public class DbConnection {

    private static DbConnection singleInstance = null;
    private OracleDataSource ods;
    private Connection conn;
    private final String url = "jdbc:oracle:thin:STUDENT/STUDENT@localhost:1521:xe";
    private Statement stmt;

    private DbConnection() {
        try {
            ods = new OracleDataSource();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ods.setURL(url);
        this.createConnection();
        this.initialiseStatement();
    }

    private void createConnection() {
        try {
            conn = ods.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void initialiseStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Statement getStmt() {
        return stmt;
    }

    public Connection getConnection() {
        return conn;
    }

    public static DbConnection getInstance() {
        if (singleInstance == null) {
            singleInstance = new DbConnection();
        }
        return singleInstance;
    }
}
