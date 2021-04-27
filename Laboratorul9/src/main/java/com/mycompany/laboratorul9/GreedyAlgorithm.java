/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9;

import com.mycompany.laboratorul9.jpa.entityclasses.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class GreedyAlgorithm extends Algorithm{
    
    public GreedyAlgorithm(List<Movie> input)
    {
        super(input);
    }

    @Override
    public Solution solve() {
        
        this.buildGraph();
        List<Pair> solution = new ArrayList<>();
        while(graph.size()>0)
        {
            Pair currentEdge = graph.get(0);
            boolean isOk = true;
            for(Pair edge : solution)
            {
                if(this.areAdjacent(edge, currentEdge))
                {
                    isOk = false;
                    break;
                }
            }
            if(isOk)
                solution.add(currentEdge);
            graph.remove(0);
        }
        return new Solution(solution);
    }
    
}
