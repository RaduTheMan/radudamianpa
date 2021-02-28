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
public class Solution {
    private int x[][];
    private Problem pb;
    public int computeCost()
    {
        int cost = 0; 
        for(int i=0; i<pb.getNrSources(); ++i)
             for(int j=0; j<pb.getNrDestinations(); ++j)
                 if(x[i][j]!=0)
                     cost += x[i][j] * pb.getCost()[i][j];
        return cost; 
    }
    public Solution(int x[][], Problem pb)
    {
        this.x = x;
        this.pb = pb;
    }

    @Override
    public String toString() {
        var s = new StringBuilder();
        for(int i=0; i<pb.getNrSources(); ++i)
            for(int j=0; j<pb.getNrDestinations(); ++j)
            {
                if(x[i][j] != 0)
                {
                    s.append(pb.getSources()[i] + " -> " + pb.getDestinations()[j] + ":");
                    s.append(" " + x[i][j] + " units * cost " + pb.getCost()[i][j] + " =  " + x[i][j] * pb.getCost()[i][j] + "\n");
                }
            }
        s.append("Total cost: "+this.computeCost());
        return s.toString();
    }
}