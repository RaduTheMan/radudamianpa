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
public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;
    
    public Church(String name, LocalTime openingTime, LocalTime closingTime)
    {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    
    public Church()
    {
        
    }
    
    @Override
    public boolean isOnlyVisitable()
    {
        return true;
    }
    
    @Override
    public LocalTime getOpeningTime()
    {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
   
    
    @Override
    public LocalTime getClosingTime()
    {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    
}
