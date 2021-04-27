/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9;

import com.mycompany.laboratorul9.jpa.entityclasses.Director;
import com.mycompany.laboratorul9.jpa.entityclasses.Movie;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Radu
 */
public class Pair {
    private Movie firstMovie;
    private Movie secondMovie;

    public Pair(Movie firstMovie, Movie secondMovie) {
        this.firstMovie = firstMovie;
        this.secondMovie = secondMovie;
    }
    
    public Pair()
    {
        
    }

    public Movie getFirstMovie() {
        return firstMovie;
    }

    public void setFirstMovie(Movie firstMovie) {
        this.firstMovie = firstMovie;
    }

    public Movie getSecondMovie() {
        return secondMovie;
    }

    public void setSecondMovie(Movie secondMovie) {
        this.secondMovie = secondMovie;
    }

    @Override
    public String toString() {
        var firstDirectorList = firstMovie.getDirectorList();
        var secondDirectorList = secondMovie.getDirectorList();
        Set<Director> firstDirectorSet = new HashSet<>(firstDirectorList);
        Set<Director> secondDirectorSet = new HashSet<>(secondDirectorList);
        firstDirectorSet.retainAll(secondDirectorSet);
        return "Movies: (" + firstMovie.getName() + ", " + secondMovie.getName() + ") Director(s):" + firstDirectorSet + '\n';
    }
    
    
    
    
}
