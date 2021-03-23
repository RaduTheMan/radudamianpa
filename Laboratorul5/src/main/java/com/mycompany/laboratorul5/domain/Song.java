/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.domain;

import com.mycompany.laboratorul5.exceptions.InvalidRatingException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Radu
 */
public class Song extends Item {

    private String genre;
    private int rating;

    public Song(String genre, String name, String path, int rating) {
        this.name = name;
        try {
            Path.of(path);
            this.pathStr = path;

        } catch (InvalidPathException e) {
            System.err.println(e);
        }
        this.genre = genre;
        if (rating < 1 || rating > 10) {
            throw new InvalidRatingException(rating);
        }
        this.rating = rating;

    }

    @Override
    public String getInstanceType() {
        return "song";
    }

    @Override
    public Map<String, String> getAttrMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("name", this.name);
        map.put("path", this.pathStr);
        map.put("genre", this.genre);
        map.put("rating", String.valueOf(this.rating));
        return map;
    }

    @Override
    public boolean isSong() {
        return true;
    }

    @Override
    public boolean isMovie() {
        return false;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Song:\n" + "\nname=" + name + "\npath=" + pathStr + "\ngenre=" + genre + "\nrating=" + rating + '}';
    }

}
