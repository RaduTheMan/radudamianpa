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
public class Main {
    public static void main(String[] args) {
        BotPlayer p1 = new BotPlayer("p1");
        ManualPlayer p2 = new ManualPlayer("p2");
        BotPlayer p3 = new BotPlayer("p3");
        Game x = new Game(3,5);
        x.registerPlayer(p1);
        x.registerPlayer(p2);
        x.registerPlayer(p3);
        x.startGame();
    }
}
