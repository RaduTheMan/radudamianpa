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
public class Problem {
    
    private Source[] sources;
    private Destination[] destinations;
    
    private int supply[];
    private int demand[];
    private int cost[][];
    
    private int nrSources;
    private int nrDestinations;

    public Problem(int nrSourcesMax, int nrDestinationsMax) {
        sources = new Source[nrSourcesMax];
        destinations = new Destination[nrDestinationsMax];
        nrSources = 0;
        nrDestinations = 0;
    }
    
    public void addSource(Source source)
    {
        if(nrSources+1 <= sources.length)
        {
            sources[nrSources++] = source;
        }
        else
            System.out.println("The maximum number of sources allowed was reached!");
    }
    
    public void addDestination(Destination destination)
    {
        if(nrDestinations+1 <= destinations.length)
        {
            destinations[nrDestinations++] = destination;
        }
        else
            System.out.println("The maximum number of destinations allowed was reached!");
    }

    public void setSupply(int[] supply) {
        if(supply.length == nrSources)
          this.supply = supply;
        else
          System.out.println("Number of supplies is not equal with the number of sources of the problem");
    }

    public void setDemand(int[] demand) {
       if(demand.length == nrDestinations) 
         this.demand = demand;
       else
         System.out.println("Number of demands is not equal with the number of destinations of the problem");
    }

    public void setCost(int[][] cost) {
        if(cost.length == nrSources)
        {
            if(cost.length == 0)
            {
                if( nrDestinations == 0)
                     this.cost = cost;
            }
            else
            {
            if(cost[0].length == nrDestinations)
               this.cost = cost;
            else
               System.out.println("The cost matrix doesn't have the coresponding number of sources/destinations of the problem");
            
            }
        }
        else
            System.out.println("The cost matrix doesn't have the coresponding number of sources/destinations of the problem");
        
    }
    
    

   
    
    
    
    
    
    
    
}
