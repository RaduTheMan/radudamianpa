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
public abstract class Player implements Runnable {
    protected String name;
    protected Map<String, Integer> choosenTokens;
    protected Game game;
    protected int identifier;
  
    public Player(String name)
    {
        this.name = name;
        this.choosenTokens = new TreeMap<>(Game::compareByToken);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    
    public abstract boolean chooseToken();
    
    @Override
    public void run() {
        while(this.game.getAvailableTokens().size() > 0)
        {
            synchronized(this.game)
            {
                if(this.game.getTurn() == this.identifier)
                {
                    this.chooseToken();
                    this.game.setTurn((this.identifier+1)%this.game.getNrPlayers());
                }
            }
        }
    }
}
