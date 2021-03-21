/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.nio.file.Path;
import java.nio.file.Files;
/**
 *
 * @author Radu
 */
public class Movie extends Item{
    private String genre;
    private int releaseYear;
    
    public Movie(String name, String path, String genre, int releaseYear)
    {
        this.name = name;
        this.pathStr = path;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
    

    @Override
    public String toString() {
        return "Movie:\n" + "\nname=" + name + "\npath=" + pathStr + "\ngenre=" + genre + ",\nreleaseYear=" + releaseYear + '}';
    }
    
    
}
