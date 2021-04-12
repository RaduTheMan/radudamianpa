/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

/**
 *
 * @author Radu
 */
public class ManualPlayer extends Player {
    
    public ManualPlayer(String name)
    {
        super(name);
    }
    
    @Override
    public boolean chooseToken() {
        return true;
    }
    
}
