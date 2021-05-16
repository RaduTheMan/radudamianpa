/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Radu
 */
public abstract class Algorithm {
    protected Map<Person, List<Person>> graph;
    protected Set<Person> visited = new HashSet<>();
    
    public Algorithm(Map<Person, List<Person>> graph)
    {
        this.graph = graph;
    }
    
    public Algorithm(List<Person> persons)
    {
        this.graph = this.buildGraph(persons);
    }
    
    private Map<Person, List<Person>> buildGraph(List<Person> persons)
    {
        Map<Person, List<Person>> solution = new HashMap<>();
        for(Person p : persons)
        {
            solution.put(p, p.getFriends());
        }
        return solution;
        
    }
    
    protected void dfs(Person currentNode)
    {
        this.visited.add(currentNode);
        for(Person neighbour : currentNode.getFriends())
        {
            if(!visited.contains(neighbour))
                dfs(neighbour);
        }      
    }
    
    protected boolean isConnected()
    {
        Person startingNode = (Person)graph.keySet().toArray()[0];
        dfs(startingNode);
        if(visited.size() != graph.keySet().size())
        {
            visited = new HashSet<>();
           return false;
        }
        visited = new HashSet<>();
        return true;
    }
    
    
    
    public abstract Solution solve();
    
}
