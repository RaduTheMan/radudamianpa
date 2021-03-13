/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4;

/**
 *
 * @author Radu
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }
    
    public static int compareByName(Student a, Student b)
    {
        return a.name.compareTo(b.name);
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
    
    
    
    
    
}
