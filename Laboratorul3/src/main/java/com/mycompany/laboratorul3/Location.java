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
public abstract class Location implements Comparable<Location> {
    protected String name;
    protected Map<Location,Integer> cost = new HashMap<>();
    
    //constructors, getters, setters
    public abstract void setName(String name);
    public abstract String getName();
    public abstract boolean isOnlyVisitable();
    
    public void setCost(Location node, int value)
    {
        cost.put(node,value);
    }
    
    // toString, etc.

    @Override
    public String toString() {
        return name;
    }
    
    
    
    @Override
    public int compareTo(Location other)
    {
        if(other.name == null)
            throw new NullPointerException();
        return this.name.compareTo(other.name);
    }
    
    
}
