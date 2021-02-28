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
public abstract class Source {

    protected String name;

    //public  Source(String name) {
        //this.name = name;
    //}

    public abstract String getName();

    public abstract void setName(String name);
    
    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Source)) {
            return false;
        }
        Source other = (Source) obj;
        return name.equals(other.name);
    }

}
