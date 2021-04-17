/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;
import oracle.jdbc.*;

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
    
    private DbConnection()
    {
        try {
            ods = new OracleDataSource();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        ods.setURL("jdbc:oracle:thin:STUDENT/STUDENT@localhost:1521:xe");
    }
    
    public void createConnection()
    {
        try {
            conn = ods.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void initialiseStatement()
    {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Statement getStmt() {
        return stmt;
    }
    
    
    
    
    
    public static DbConnection getInstance()
    {
        if(singleInstance == null)
            singleInstance = new DbConnection();
        return singleInstance;
    }
}
