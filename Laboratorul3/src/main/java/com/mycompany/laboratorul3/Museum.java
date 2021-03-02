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
public class Museum implements Visitable, Payable {
    private String name;
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    
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
    public double getTicketPrice()
    {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
