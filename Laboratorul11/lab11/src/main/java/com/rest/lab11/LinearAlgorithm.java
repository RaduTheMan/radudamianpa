/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Radu
 */
public class LinearAlgorithm extends Algorithm {

    public LinearAlgorithm(Map<Person, List<Person>> graph) {
        super(graph);
    }
    
    public LinearAlgorithm(List<Person> persons){
        super(persons);
    }

    @Override
    public Solution solve() {
        if(!this.isConnected())
        {
            System.out.println("graful nu este conex");
            return null;
        }
        System.out.println("graful  este conex");
        return new Solution(new ArrayList<>());
    }
    
}
