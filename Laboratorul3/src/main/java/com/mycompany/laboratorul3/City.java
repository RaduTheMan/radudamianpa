/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul3;
import java.util.*;
/**
 *
 * @author Radu
 */
public class City {
    private String name;
    private List<Location> nodes = new ArrayList<>();
    
    //constructors, getters, setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addLocation(Location node)
    {
        nodes.add(node);
    }
    
    public void displayOnlyVisible()
    {
        for(int i=0;i<nodes.size();++i)
            if(nodes.get(i).isOnlyVisitable() == true)
                System.out.println(nodes.get(i));
    }
    
    
    
    //toString, etc

    @Override
    public String toString() {
        return name;
    }
    
    
}
