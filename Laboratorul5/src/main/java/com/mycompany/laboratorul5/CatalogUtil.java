/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.awt.Desktop;
import java.io.IOException;

/**
 *
 * @author Radu
 */
public class CatalogUtil {
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
