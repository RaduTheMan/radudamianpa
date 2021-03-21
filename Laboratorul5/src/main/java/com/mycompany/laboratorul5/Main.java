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
        app.testCreateViewSave();
        app.testLoadView();
    }
    
    private void testCreateViewSave()
    {
        Catalog catalog = new Catalog("My entertainment hub","e:/Catalogs/catalog1.ser");
        var song = new Song("Haken #1","e:/Muzica/Veil.mp3", "progressive metal",9);
        var movie = new Movie("Airplane","e:/Filme/Airplane.1980.720p.BluRay.DTS.x264.RoSubbed-AMIABLE/Airplane.1980.720p.BluRay.DTS.x264.RoSubbed-AMIABLE.mkv", "comedy",1980);
        catalog.add(song);
        catalog.add(movie);
        catalog.list();
        //CatalogUtil.view(song);
        //CatalogUtil.view(movie);
        CatalogUtilBinary.save(catalog);
        CatalogUtilBinary.view(song);
    }
    
    private void testLoadView()
    {
        Catalog catalog = CatalogUtilBinary.load("e:/Catalogs/catalog1.ser");
        CatalogUtil.view(catalog.findByName("Airplane"));
    }
    
}
