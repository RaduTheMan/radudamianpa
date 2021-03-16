/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

/**
 *
 * @author Radu
 */
public class Movie extends Item{
    private String genre;
    private int releaseYear;
    
    public Movie(String name, String path, String genre, int releaseYear, String id)
    {
        this.name = name;
        this.path = path;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie:\nid="+ id+ "\nname=" + name + "\npath=" + path + "\ngenre=" + genre + ",\nreleaseYear=" + releaseYear + '}';
    }
    
    
}
