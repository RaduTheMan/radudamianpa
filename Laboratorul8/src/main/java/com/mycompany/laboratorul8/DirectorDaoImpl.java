/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class DirectorDaoImpl implements DirectorDao {
    
    List<Director> directors = new ArrayList<>();
    DbConnection connection;
    private final String querryAllDirectors = "select * from directors";

    public DirectorDaoImpl(DbConnection connection)
    {
        this.connection = connection;
        Statement stmt = connection.getStmt();
        ResultSet rset;
        //get all directors from database
        try {
            rset = stmt.executeQuery(querryAllDirectors);
            while (rset.next()) {
                int id = rset.getInt("id_director");
                String firstName = rset.getString("first_name");
                String lastName = rset.getString("last_name");
                directors.add(new Director(id,firstName,lastName));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public List<Director> getAllDirectors() {
        return new ArrayList<>(directors);
        
    }

    @Override
    public Director getDirector(int id) {
        for(Director director : directors)
            if(director.getId() == id)
                return director;
        return null;
    }

    @Override
    public void updateDirector(Director director) {
        for(Director directorFromList : directors)
        {
            if(directorFromList.getId() == director.getId())
            {
                int index = directors.indexOf(directorFromList);
                directors.set(index, director);

                //update in database
                String dmlStatement = "UPDATE directors SET first_name = ?, "
                        + "last_name = ? WHERE id_director = ?";
                try {
                    var pstmt = connection.getConnection().prepareStatement(dmlStatement);
                    pstmt.setString(1, director.getFirstName());
                    pstmt.setString(2, director.getLastName());
                    pstmt.setInt(3, director.getId());
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    @Override
    public void deleteDirector(Director director) {
        boolean isDeleted = directors.remove(director);
        PreparedStatement pstmt = null;
        if (isDeleted) //delete from the database
        {
            String dmlStatement = "DELETE FROM directors WHERE id_director = ?";
            try {
                pstmt = connection.getConnection().prepareStatement(dmlStatement);
                pstmt.setInt(1, director.getId());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }
    
}
