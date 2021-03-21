/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.awt.Desktop;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author Radu
 */
public class CatalogUtil {
    
    public static void save(Catalog catalog)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(catalog.getPath());
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
    
    public static Catalog load(String path)
    {
        try
        {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fis);
        Catalog catalog = (Catalog)in.readObject();
        return catalog;
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println(e);
        }
        return null;
    }
    
    public static void view(Item item)
    {
        Desktop desktop = Desktop.getDesktop();
        try
        {
        desktop.open(item.getFile());
        }
        catch(IOException e)
        {
            System.out.println("Unexpected error opening the file!");
            System.err.println(e);
        }
        
    }
    
}
