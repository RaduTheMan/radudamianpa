/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8.daoimplementations;

import com.mycompany.laboratorul8.singleton.DbConnection;
import com.mycompany.laboratorul8.domain.Genre;
import com.mycompany.laboratorul8.daointerface.GenreDao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Radu
 */
public class GenreDaoImpl implements GenreDao {

    List<Genre> genres = new ArrayList<>();
    DbConnection connection;
    private final String querryAllGenres = "select * from genres";

    public GenreDaoImpl(DbConnection connection) {
        this.connection = connection;
        Statement stmt = connection.getStmt();
        ResultSet rset;
        //get all genres from database
        try {
            rset = stmt.executeQuery(querryAllGenres);
            while (rset.next()) {
                int id = rset.getInt("id_genre");
                String name = rset.getString("name");
                genres.add(new Genre(id, name));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Genre> getAllGenres() {
        return new ArrayList<>(genres);
    }

    @Override
    public Genre getGenre(int id) {
        for (Genre genre : genres) {
            if (genre.getId() == id) {
                return genre;
            }
        }
        return null;
    }

    @Override
    public void updateGenre(Genre genre) {
        for (Genre genreFromList : genres) {
            if (genreFromList.getId() == genre.getId()) {
                int index = genres.indexOf(genreFromList);
                genres.set(index, genre);

                //update in database
                String dmlStatement = "UPDATE genres SET name = ? WHERE id_genre = ?";
                try {
                    var pstmt = connection.getConnection().prepareStatement(dmlStatement);
                    pstmt.setString(1, genre.getName());
                    pstmt.setInt(2, genre.getId());
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        }
    }

    @Override
    public void deleteGenre(Genre genre) {
        boolean isDeleted = genres.remove(genre);
        if (isDeleted) //delete from the database
        {
            String dmlStatement = "DELETE FROM genres WHERE id_genre = ?";
            try {
                var pstmt = connection.getConnection().prepareStatement(dmlStatement);
                pstmt.setInt(1, genre.getId());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

}
