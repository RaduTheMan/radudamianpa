/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Radu
 */
public class MovieDaoImpl implements MovieDao {

    List<Movie> movies = new ArrayList<>();
    DbConnection connection;
    private final String querryAllMovies = "select * from movies";

    //converts a String of format "n n:n:n" into a String of format "PnDTnHnMn.nS"
    private String convertDurationFromDb(String durationFromDb) {
        String newDurationFromDb = durationFromDb.replace(" ", ":");
        String[] units = newDurationFromDb.split(":");
        String solution = "P" + units[0] + "DT" + units[1] + "H" + units[2] + "M" + units[3] + "S";
        return solution;
    }

    //converts a String of format "PTnHnM" into a String of format "0 n:n:0"
    private String convertDurationFromObj(String durationFromObj) {
        String[] units = durationFromObj.split("PT|H|M");
        String solution = "0 " + units[1] + ":" + units[2] + ":0";
        return solution;
    }

    public MovieDaoImpl(DbConnection connection) {
        this.connection = connection;
        Statement stmt = connection.getStmt();
        ResultSet rset;
        //get all movies from database
        try {
            rset = stmt.executeQuery(querryAllMovies);
            while (rset.next()) {
                int id = rset.getInt("id_movie");
                String title = rset.getString("title");
                Date releaseDate = rset.getDate("release_date");
                String durationStr = rset.getString("duration");
                int score = rset.getInt("score");
                durationStr = this.convertDurationFromDb(durationStr);
                Duration duration = Duration.parse(durationStr);
                movies.add(new Movie(id, title, releaseDate, duration, score));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    @Override
    public Movie getMovie(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public void updateMovie(Movie movie) {
        for (Movie movieFromList : movies) {
            if (movieFromList.getId() == movie.getId()) {
                int index = movies.indexOf(movieFromList);
                movies.set(index, movie);

                //update in database
                String dmlStatement = "UPDATE movies SET title = ?, "
                        + "release_date = TO_DATE(?, 'yyyy/mm/dd'), "
                        + "duration = TO_DSINTERVAL(?), "
                        + "score = ?  WHERE id_movie = ?";
                try {
                    var pstmt = connection.getConnection().prepareStatement(dmlStatement);
                    pstmt.setString(1, movie.getTitle());
                    pstmt.setString(2, movie.getReleaseDate().toString());
                    String durationForDb = convertDurationFromObj(movie.getDuration().toString());
                    pstmt.setString(3, durationForDb);
                    pstmt.setInt(4, movie.getScore());
                    pstmt.setInt(5, movie.getId());
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        }
    }

    @Override
    public void deleteMovie(Movie movie) {
        boolean isDeleted = movies.remove(movie);
        PreparedStatement pstmt = null;
        if (isDeleted) //delete from the database
        {
            String dmlStatement = "DELETE FROM movies WHERE id_movie = ?";
            try {
                pstmt = connection.getConnection().prepareStatement(dmlStatement);
                pstmt.setInt(1, movie.getId());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }

}
