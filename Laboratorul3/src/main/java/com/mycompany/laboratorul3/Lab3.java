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
        City cityObj1 = new City();
        cityObj1.setName("Iasi");
        
        Museum museumObj1 = new Museum();
        museumObj1.setOpeningTime(LocalTime.of(9, 30));
        museumObj1.setClosingTime(LocalTime.parse("17:00"));
        museumObj1.setTicketPrice(30);
        museumObj1.setName("Lovre");
        
        Church churchObj1 = new Church();
        churchObj1.setOpeningTime(LocalTime.of(7,0));
        churchObj1.setClosingTime(LocalTime.MIDNIGHT);
        churchObj1.setName("Trei Ierarhi");
        
        Church churchObj2 = new Church("Inaltarea Domnului", LocalTime.of(9, 0), LocalTime.MIDNIGHT);
        
        Church churchObj3 = new Church("AA", LocalTime.of(8, 0), LocalTime.MIDNIGHT);
        
        Church churchObj4 = new Church("AAB", LocalTime.of(3, 0), LocalTime.MIDNIGHT);
        
        Restaurant restObj1 = new Restaurant("Mamma-mia", 4);
        Hotel hotelObj1 = new Hotel("Moldova", 3);
        
        Visitable[] arr = {museumObj1,churchObj1};
        Location[] locations = {museumObj1,churchObj1,hotelObj1,churchObj3,restObj1,churchObj2,churchObj4};
        churchObj2.setDefaultOpeningTime();
        churchObj2.setDefaultClosingTime();
        
        System.out.println("Visitable:");
        
        for(int i=0;i<arr.length;++i)
            System.out.println(arr[i]);
        
        System.out.println("");
        
        System.out.println("Locations:");
        
        for(int i=0;i<locations.length;++i)
            System.out.println(locations[i]);
        
        Arrays.sort(locations);
        
        System.out.println("");
        
        System.out.println("Sorted locations by name:");
        
        for(int i=0;i<locations.length;++i)
            System.out.println(locations[i]);
        
        
        
        for(int i=0;i<locations.length;++i)
            cityObj1.addLocation(locations[i]);
        
        System.out.println("");
        
        System.out.println("Only visitable locations:");
        
        cityObj1.displayOnlyVisible();
        
        System.out.println(Visitable.getDuration(churchObj2));
      }
        
    
    
}
