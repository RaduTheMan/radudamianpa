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
public class Song extends Item{
    private String genre;
    private int rating;
    
    public Song(String name, String path, String genre, int rating)
    {
        this.name = name;
        this.pathStr = path;
        this.genre = genre;
        this.rating = rating;
    }
    

    @Override
    public String toString() {
        return "Song:\n" + "\nname=" + name + "\npath=" + pathStr + "\ngenre=" + genre + ",\nrating=" + rating + '}';
    }
    
    
}
