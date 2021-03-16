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
public class Song extends Item{
    private String genre;
    private int rating;
    
    public Song(String name, String path, String genre, int rating, String id)
    {
        this.name = name;
        this.path = path;
        this.genre = genre;
        this.rating = rating;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Song:\nid="+ id+ "\nname=" + name + "\npath=" + path + "\ngenre=" + genre + ",\nrating=" + rating + '}';
    }
    
    
}
