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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getListLocations() {
        return new ArrayList<>(nodes);
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public void displayOnlyVisible() {
        List<Visitable> onlyVisitableTemp = new ArrayList<>();
        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i).isOnlyVisitable() == true) {
                Location x = nodes.get(i);
                Visitable y = (Visitable) x;
                onlyVisitableTemp.add(y);
            }
        }

        //sortare dupa openingTime
        Collections.sort(onlyVisitableTemp, new Comparator<Visitable>() {
            public int compare(Visitable c1, Visitable c2) {
                return c1.getOpeningTime().compareTo(c2.getOpeningTime());
            }
        });

        for (int i = 0; i < onlyVisitableTemp.size(); ++i) {
            System.out.println(onlyVisitableTemp.get(i) + " " + onlyVisitableTemp.get(i).getOpeningTime().toString() + " " + onlyVisitableTemp.get(i).getClosingTime().toString());
        }
    }

    //toString, etc
    @Override
    public String toString() {
        return name;
    }

}
