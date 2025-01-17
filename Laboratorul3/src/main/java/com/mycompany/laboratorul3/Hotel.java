/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul3;

/**
 *
 * @author Radu
 */
public class Hotel extends Location implements Classifiable {

    private int rank;

    public Hotel(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public Hotel() {

    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public boolean isOnlyVisitable() {
        return false;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
