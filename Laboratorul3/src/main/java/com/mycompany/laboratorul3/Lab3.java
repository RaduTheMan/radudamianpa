/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul3;
import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author Radu
 */
public class Lab3 {
    
    public static void main(String args[])
    {
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9, 30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(30);
        m.setName("Lovre");
        
        Church c = new Church();
        c.setOpeningTime(LocalTime.of(7,0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        c.setName("Trei Ierarhi");
        
        Restaurant r = new Restaurant("Mamma-mia", 4);
        Hotel h = new Hotel("Moldova", 3);
        
        Visitable[] arr = {m,c};
        Location[] locations = {m,c,h,r};
        
        for(int i=0;i<arr.length;++i)
            System.out.println(arr[i]);
        
        System.out.println("");
        
        for(int i=0;i<locations.length;++i)
            System.out.println(locations[i]);
        
        Arrays.sort(locations);
        
        System.out.println("");
        
        for(int i=0;i<locations.length;++i)
            System.out.println(locations[i]);
        
    }
    
}
