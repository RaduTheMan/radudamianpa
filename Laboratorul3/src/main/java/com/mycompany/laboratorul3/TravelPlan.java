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
public class TravelPlan {
    
    private City city;
    private List<Location> preferences;
    private final int INFINIT;
    public TravelPlan(City city)
    {
        this.city=city;
        this.preferences = this.city.getListLocations();
        this.INFINIT = 999999;
    }
    private int getCostArc(int sourceIndex,  int destinationIndex)
    {
        Location source = preferences.get(sourceIndex);
        Location destination = preferences.get(destinationIndex);
        Map<Location,Integer> tempCost;
        tempCost = source.getCost();
        for(Map.Entry<Location,Integer> entry : tempCost.entrySet())
            if(entry.getKey()==destination)
                return entry.getValue();
        return INFINIT;
    }
    public int getShortestPath(Location start, Location finish)
    {
        //dijkstra
        int n=preferences.size(),startIndex=preferences.indexOf(start),finishIndex=preferences.indexOf(finish);
        int d[] = new int[n+5]; //array care tine evidenta legat de cel mai scurt drum de la start la celelalte locatii
        boolean viz[] = new boolean[n+5], ok=true;
        viz[startIndex] = true;
        for(int i=0;i<n;++i)
        {
            if(i==startIndex)
                d[i] = 0;
            else 
                d[i]=getCostArc(startIndex,i);
        }
        while(ok == true)
        {
            int min=INFINIT,currentIndex=-1;
            for(int i=0;i<n;++i)
                if(d[i]<min && !viz[i])
                {
                    min=d[i];
                    currentIndex=i;
                }
            if(min==INFINIT)
            {
                ok = false;
                continue;
            }
            viz[currentIndex] = true;
            Location currentLocation = preferences.get(currentIndex);
            Map<Location,Integer> tempCost;
            tempCost = currentLocation.getCost();
            for(Map.Entry<Location,Integer> entry : tempCost.entrySet())
            {
                int neighbourIndex = preferences.indexOf(entry.getKey());
                if(d[currentIndex] + entry.getValue() < d[neighbourIndex] && !viz[neighbourIndex])
                {
                    d[neighbourIndex] = d[currentIndex]+entry.getValue();
                }
            }
        }
            
        return d[finishIndex];
    }
}
