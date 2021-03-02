/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul3;
import java.time.LocalTime;

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
        
        Church c = new Church();
        c.setOpeningTime(LocalTime.of(7,0));
        //c.setClosingTime(LocalTime.MIN);
        
        Visitable[] arr = {m};
    }
    
}
