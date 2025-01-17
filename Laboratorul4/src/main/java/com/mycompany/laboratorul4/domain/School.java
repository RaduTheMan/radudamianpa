/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4.domain;

/**
 *
 * @author Radu
 */
public class School implements Comparable<School> {

    private String name;
    private int capacity;

    public School(String name) {
        this.name = name;
        this.capacity = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School other) {
        if (other.name == null) {
            throw new NullPointerException();
        }
        return this.name.compareTo(other.name);
    }

}
