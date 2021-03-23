/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.domain;

import com.mycompany.laboratorul5.exceptions.InvalidYearException;
import java.nio.file.InvalidPathException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Radu
 */
public class Movie extends Item{
    private String genre;
    private int releaseYear;
    
    public Movie(String genre, String name, String path, int releaseYear)
    {
        this.name = name;
        try
        {
        this.pathStr = path;
        }
        catch(InvalidPathException e)
        {
            System.err.println(e);
        }
        this.genre = genre;
        if(releaseYear < 0)
            throw new InvalidYearException(releaseYear);
        this.releaseYear = releaseYear;
    }
    
    @Override
    public Map<String, String> getAttrMap()
    {
        Map<String, String> map= new TreeMap<>();
        map.put("name", this.name);
        map.put("path", this.pathStr);
        map.put("genre", this.genre);
        map.put("releaseYear", String.valueOf(this.releaseYear));
        return map;
    }
    
    @Override
    public String getInstanceType()
    {
        return "movie";
    }
    
    @Override
    public boolean isSong()
    {
        return false;
    }
    
    @Override
    public boolean isMovie()
    {
        return true;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    

    @Override
    public String toString() {
        return "Movie:\n" + "\nname=" + name + "\npath=" + pathStr + "\ngenre=" + genre + ",\nreleaseYear=" + releaseYear + '}';
    }
    
    
}
