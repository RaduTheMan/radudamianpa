/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul2;

/**
 *
 * @author Radu
 */
public class Destination {
    private String name;

    public Destination(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Destination))
            return false;
        Destination other = (Destination) obj;
        return name.equals(other.name);
    }
}
