/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.main;

import com.mycompany.laboratorul5.domain.Catalog;
import com.mycompany.laboratorul5.domain.CatalogUtil;
import com.mycompany.laboratorul5.domain.Movie;
import com.mycompany.laboratorul5.domain.Song;
import com.mycompany.laboratorul5.commands.Shell;

/**
 *
 * @author Radu
 */
public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        //app.testCreateViewSave();
        //app.testLoadView();
        app.testShell();
    }

    private void testCreateViewSave() {
        Catalog catalog = new Catalog("My entertainment hub", "e:/Catalogs/catalog1.ser");
        var song = new Song("progressive metal", "Haken #1", "e:/Muzica/Veil.mp3", 9);
        var movie = new Movie("comedy", "Airplane", "e:/Filme/Airplane.1980.720p.BluRay.DTS.x264.RoSubbed-AMIABLE/Airplane.1980.720p.BluRay.DTS.x264.RoSubbed-AMIABLE.mkv", 1980);
        catalog.add(song);
        catalog.add(movie);
        catalog.list();
        //CatalogUtil.view(song);
        //CatalogUtil.view(movie);
        CatalogUtil.saveWithBinary(catalog);
        CatalogUtil.saveWithXML(catalog);
        //CatalogUtil.view(song);
    }

    private void testLoadView() {
        Catalog catalog = CatalogUtil.loadWithBinary("e:/Catalogs/catalog1.ser");
        Catalog catalog2 = CatalogUtil.loadWithXML("e:/Catalogs/catalog1.xml");
        CatalogUtil.view(catalog.findByName("Airplane"));
        CatalogUtil.view(catalog2.findByName("Haken #1"));
    }

    private void testShell() {
        Shell shell = new Shell();
        shell.run();
    }

}
