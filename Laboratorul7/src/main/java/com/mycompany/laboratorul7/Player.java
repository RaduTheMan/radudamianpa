/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

import java.util.List;
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
    protected List<List<Integer>> sequences;
    protected int score = 0;

    public Player(String name) {
        this.name = name;
        this.choosenTokens = new TreeMap<>(Game::compareByToken);
    }

    public static int compareByScore(Player a, Player b) {
        if (a.getScore() < b.getScore()) {
            return -1;
        }
        if (a.getScore() > b.getScore()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.name + " " + this.score + " " + this.sequences;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getChoosenTokens() {
        return choosenTokens;
    }

    public void setSequences(List<List<Integer>> sequences) {
        this.sequences = sequences;
    }

    public void calculateScore() {
        for (var sequence : sequences) {
            int lg = sequence.size();
            for (int i = 0; i < lg; ++i) {
                int a = sequence.get(i);
                int b = sequence.get((i + 1) % lg);

                String key = Math.min(a, b) + "," + Math.max(a, b);
                this.score += this.choosenTokens.get(key);
            }

        }
    }

    public int getScore() {
        return score;
    }

    public abstract boolean chooseToken();

    @Override
    public void run() {
        while (this.game.getAvailableTokens().size() > 0) {
            synchronized (this.game) {
                if (this.game.getTurn() == this.identifier) {
                    this.chooseToken();
                    this.game.setTurn((this.identifier + 1) % this.game.getNrPlayers());
                }
            }
        }
    }
}
