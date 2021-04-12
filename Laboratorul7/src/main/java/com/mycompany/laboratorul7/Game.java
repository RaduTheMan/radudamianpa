/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Radu
 */
public class Game {
 
    private Map<String, Integer> availableTokens;
    private List<Player> players;
    private final int nrPlayers;
    private final int n;
    private final int MAX_VALUE = 10;
    private int turn = 0;
    
    public static int compareByToken(String a, String b)
    {
        int x1, x2, y1, y2;
        String[] x1_x2 = a.split(",");
        String[] y1_y2 = b.split(",");
        x1 = Integer.parseInt(x1_x2[0]);
        x2 = Integer.parseInt(x1_x2[1]);
        y1 = Integer.parseInt(y1_y2[0]);
        y2 = Integer.parseInt(y1_y2[1]);
        if(x1 < y1)
            return -1;
        if(y1 < x1)
            return 1;
        if(x2 < y2)
            return -1;
        if(x2 > y2)
            return 1;
        return 0;
    }
    public static int getRandomNumber(int a, int b)
    {
        return (int) (Math.random() * (b-a) + a);
    }
    public Game(int nrPlayers, int n) 
    {
       this.nrPlayers = nrPlayers;
       this.n = n;
       this.players = new ArrayList<>();
       
       //initialise the board
       this.availableTokens = new TreeMap<>(Game::compareByToken);
       for(int i=1;i<n;++i)
           for(int j=i+1;j<=n;++j)
           {
               int value = getRandomNumber(1, MAX_VALUE+1);
               String key = i + "," + j;
               this.availableTokens.put(key, value);
           }
    }

    public Map<String, Integer> getAvailableTokens() {
        return availableTokens;
    }

    public int getNrPlayers() {
        return nrPlayers;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    
    
    
    public boolean registerPlayer(Player player)
    {
        if(players.size()<this.nrPlayers)
        {
            players.add(player);
            return true;
        }
        return false;
    }
    public void startGame()
    {
        if(players.size()==this.nrPlayers)
        {
            for(int i=0; i<this.nrPlayers;++i)
            {
                players.get(i).setGame(this);
                players.get(i).setIdentifier(i);
                new Thread(players.get(i)).start();
            }
        }
    }
}
