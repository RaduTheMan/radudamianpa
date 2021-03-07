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
public interface Visitable {
    
    public LocalTime getOpeningTime();
    public LocalTime getClosingTime();
    public void setOpeningTime(LocalTime openingTime);
    public void setClosingTime(LocalTime closingTime);
    public default void setDefaultOpeningTime()
    {
        LocalTime defaultOpeningTime = LocalTime.of(9,30);
        setOpeningTime(defaultOpeningTime);
    }
    public default void setDefaultClosingTime()
    {
        LocalTime defaultClosingTime = LocalTime.of(20, 0);
        setClosingTime(defaultClosingTime);
    }
    
    
}
