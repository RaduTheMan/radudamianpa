/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;
import java.sql.*;
/**
 *
 * @author Radu
 */
public class Main  {
    public static void main(String[] args) throws SQLException {
    
    //using the singleton
    DbConnection connection = DbConnection.getInstance();

    GenreDao genreDao = new GenreDaoImpl(connection);
    genreDao.deleteGenre(new Genre(1,"Drama"));
    
    }
   
}
