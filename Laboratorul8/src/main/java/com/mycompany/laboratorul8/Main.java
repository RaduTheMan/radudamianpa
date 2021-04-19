/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;
import java.time.Duration;
/**
 *
 * @author Radu
 */
public class Main  {
    public static void main(String[] args) {
    
    //using the singleton
    DbConnection connection = DbConnection.getInstance();

    GenreDao genreDao = new GenreDaoImpl(connection);
    MovieDao movieDao = new MovieDaoImpl(connection);
    Movie someMovie = movieDao.getMovie(1);
    someMovie.setTitle("Car");
    someMovie.setScore(4);
    someMovie.setDuration(Duration.parse("PT1H45M"));
    movieDao.updateMovie(someMovie);
    
    genreDao.deleteGenre(genreDao.getGenre(1));
    
    }
    
   
}
