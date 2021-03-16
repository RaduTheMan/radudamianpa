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
public class Main {
    
    public static void main(String[] args)
    {
        Main app = new Main();
        app.testCreate();
    }
    
    private void testCreate()
    {
        Catalog catalog = new Catalog("My entertainment hub","e:/Catalogs/catalog1.ser");
        var song = new Song("Haken #1","e:/Muzica/Veil.mp3", "progressive metal",9,"1");
        var movie = new Movie("12 angry men","e:/Filme/12.Angry.Men.1957.1080p.BluRay.x264-CiNEFiLE/12.Angry.Men.1957.1080p.BluRay.x264-CiNEFiLE.mkv", "drama",1957,"2");
        catalog.add(song);
        catalog.add(movie);
        catalog.list();
        
    }
    
}
