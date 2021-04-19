/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;

import java.util.List;

/**
 *
 * @author Radu
 */
public interface MovieDao {
    public List<Movie> getAllMovies();
    public Movie getMovie(int id);
    public void updateMovie(Movie movie);
    public void deleteMovie(Movie movie);
}
