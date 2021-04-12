/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class BotPlayer extends Player {

    
    public BotPlayer(String name)
    {
        super(name);
    }
    
    @Override
    public boolean chooseToken() {
        int index;
        var availableTokens = this.game.getAvailableTokens();
        int nrAvailableTokens = availableTokens.size();
        
        if(nrAvailableTokens > 0)
        {
        List<String> keyList = new ArrayList<>(availableTokens.keySet());
        index = Game.getRandomNumber(0, nrAvailableTokens);
        String randomKey = keyList.get(index);
        Integer value = availableTokens.get(randomKey);
        this.choosenTokens.put(randomKey, value);
        availableTokens.remove(randomKey);
        System.out.println(this.name + ": I choose " + randomKey + " " + value);
        return true;
        }
        return false;
    }
    
}
