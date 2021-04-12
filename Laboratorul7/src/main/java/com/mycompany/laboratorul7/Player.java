/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Radu
 */
public class Player implements Runnable {
    private String name;
    private Map<String, Integer> choosenTokens;
  
    public Player(String name)
    {
        this.name = name;
        this.choosenTokens = new TreeMap<>(Game::compareByToken);
    }
    @Override
    public void run() {
        System.out.println("Ma cheama: " + this.name);
    }
}
