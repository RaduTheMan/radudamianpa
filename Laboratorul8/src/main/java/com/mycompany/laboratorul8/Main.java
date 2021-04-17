/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;
/**
 *
 * @author Radu
 */
public class Main  {
    public static void main(String[] args) throws SQLException {
    
    //using the singleton
    DbConnection connection = DbConnection.getInstance();
    connection.createConnection();
    connection.initialiseStatement();

    //get statement object
    Statement stmt = connection.getStmt();
    
    // run a querry:
    ResultSet rset = stmt.executeQuery ("select * from movies");
    while (rset.next())
      System.out.println (rset.getString("title"));
    }
   
}
