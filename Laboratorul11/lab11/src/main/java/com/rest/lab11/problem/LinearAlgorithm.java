/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11.problem;

import com.rest.lab11.entities.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Radu
 */
public class LinearAlgorithm extends Algorithm {

    private int time = 0;
    private Set<Person> solution = new HashSet<>();

    public LinearAlgorithm(Map<Person, List<Person>> graph) {
        super(graph);
    }

    public LinearAlgorithm(List<Person> persons) {
        super(persons);
    }

    private void dfsAP(Person currentNode, Map<Person, Integer> disc, Map<Person, Integer> low, Map<Person, Person> parent) {
        int children = 0;

        visited.add(currentNode);

        disc.put(currentNode, ++time);
        low.put(currentNode, time);

        for (Person neighbour : currentNode.getFriends()) {
            if (!visited.contains(neighbour)) {
                children++;
                parent.put(neighbour, currentNode);
                dfsAP(neighbour, disc, low, parent);

                low.put(currentNode, Math.min(low.get(currentNode), low.get(neighbour)));

                if (parent.get(currentNode) == null && children > 1) {
                    solution.add(currentNode);
                }
                if (parent.get(currentNode) != null && low.get(neighbour) >= disc.get(currentNode)) {
                    solution.add(currentNode);
                }

            } else if (!neighbour.equals(parent.get(currentNode))) {
                low.put(currentNode, Math.min(low.get(currentNode), disc.get(neighbour)));
            }
        }

    }

    @Override
    public Solution solve() {
        if (!this.isConnected()) {
            System.out.println("graful nu este conex");
            return null;
        }
        System.out.println("graful  este conex");
        Person startingNode = (Person) graph.keySet().toArray()[0];

        int nrNodes = graph.keySet().size();
        this.time = 0;
        this.solution = new HashSet<>();
        Map<Person, Integer> disc = new HashMap<>();
        Map<Person, Integer> low = new HashMap<>();
        Map<Person, Person> parent = new HashMap<>();
        dfsAP(startingNode, disc, low, parent);
        return new Solution(new HashSet<>(solution));
    }

}
