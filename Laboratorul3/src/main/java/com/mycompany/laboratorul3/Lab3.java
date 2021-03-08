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
        //creare obiecte location
        City cityObj1 = new City();
        cityObj1.setName("Iasi");
        
        Museum museumObj1 = new Museum();
        museumObj1.setOpeningTime(LocalTime.of(9, 30));
        museumObj1.setClosingTime(LocalTime.parse("17:00"));
        museumObj1.setTicketPrice(30);
        museumObj1.setName("Lovre");
        
        Museum museumObj2 = new Museum("Antipa",12, LocalTime.of(9,0),LocalTime.of(16, 0));
        
        Church churchObj1 = new Church();
        churchObj1.setOpeningTime(LocalTime.of(7,0));
        churchObj1.setClosingTime(LocalTime.MIDNIGHT);
        churchObj1.setName("Trei Ierarhi");
        
        Church churchObj2 = new Church("Inaltarea Domnului", LocalTime.of(9, 0), LocalTime.MIDNIGHT);
        Church churchObj3 = new Church("AA", LocalTime.of(8, 0), LocalTime.MIDNIGHT);
        Church churchObj4 = new Church("AAB", LocalTime.of(3, 0), LocalTime.MIDNIGHT);
        
        Restaurant restObj1 = new Restaurant("Mamma-mia", 4);
        Hotel hotelObj1 = new Hotel("Moldova", 3);
        
        //creare doi vectori, unul cu locatii Visitable, celalalt cu orice tip de locatie 
        Visitable[] arr = {museumObj1,churchObj1};
        Location[] locations = {museumObj1,museumObj2,churchObj1,churchObj2,hotelObj1,restObj1};
        churchObj2.setDefaultOpeningTime();
        churchObj2.setDefaultClosingTime();
        
        //initializare costuri
        hotelObj1.setCost(museumObj1, 10);
        hotelObj1.setCost(museumObj2, 50);
        museumObj1.setCost(museumObj2, 20);
        museumObj1.setCost(churchObj1, 20);
        museumObj1.setCost(churchObj2, 10);
        museumObj2.setCost(churchObj1, 20);
        churchObj1.setCost(churchObj2, 30);
        churchObj1.setCost(restObj1, 10);
        churchObj2.setCost(restObj1, 20);
        
        
        
        //afisarea locatiilor Visitable
        System.out.println("Visitable:");
        
        for(int i=0;i<arr.length;++i)
            System.out.println(arr[i]);
        
        System.out.println("");
        
        //afisarea locatiilor de orice tip
        System.out.println("Locations:");
        
        for(int i=0;i<locations.length;++i)
            System.out.println(locations[i]);
        
        //sortare vector cu locatii
        Arrays.sort(locations);
        
        System.out.println("");
        
        //afisare vector cu locatii sortat dupa nume
        System.out.println("Sorted locations by name:");
        
        for(int i=0;i<locations.length;++i)
            System.out.println(locations[i]);
        
        
        //adaugare in oras diverse locatii
        for(int i=0;i<locations.length;++i)
            cityObj1.addLocation(locations[i]);
        
        System.out.println("");
        
        //afisare doar locatii Visitable
        System.out.println("Only visitable locations:");
        
        cityObj1.displayOnlyVisible();
        
        //testare metoda getDuration pentru o locatie Visitable
        System.out.println(Visitable.getDuration(churchObj2));
        
        //initializare instanta TravelPlan
        TravelPlan plan = new TravelPlan(cityObj1);
        
        //testare dijkstra pe exemplu
        for(int i=0;i<locations.length;++i)
            for(int j=0;j<locations.length;++j)
            {
                System.out.println("Shortest distance from "+ locations[i] + " to " + locations[j]+ " is: " + plan.getShortestPath(locations[i], locations[j]));
            }
        System.out.println(plan.getShortestPath(restObj1, hotelObj1));
      }
        
    
    
}
