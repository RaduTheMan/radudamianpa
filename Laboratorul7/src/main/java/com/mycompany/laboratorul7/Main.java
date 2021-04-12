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
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        Game x = new Game(3,6);
        x.registerPlayer(p1);
        x.registerPlayer(p2);
        x.registerPlayer(p3);
        x.startGame();
    }
}
