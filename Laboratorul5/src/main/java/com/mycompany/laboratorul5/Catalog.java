/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;
/**
 *
 * @author Radu
 */
public class Catalog {
    
    private String name;
    private String path;
    Path newFile;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        
        try
        {
            Path aux = Path.of(path);
            this.newFile = Files.createFile(aux);
        }
        catch(IOException e)
        {
            System.out.println("Unexpected error creating the catalog!");
            System.err.println(e);
        }
    }
    
    
    public void add(Item item)
    {
        items.add(item);
    }
    
    public void list()
    {
        for(Item i : items)
        {
            System.out.println(i);
        }
    }
}
