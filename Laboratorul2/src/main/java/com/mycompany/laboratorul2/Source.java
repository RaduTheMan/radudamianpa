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
public class Source {
    private String name;
    private SourceType type;

    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Source))
            return false;
        Source other = (Source) obj;
        return name.equals(other.name);
    }
    
    
    
}
