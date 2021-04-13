/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static int cycleNumber = 0;

    //metoda pentru a ordona cheile din cadrul mapei "availableTokens" (de tip TreeMap)
    public static int compareByToken(String a, String b) {
        int x1, x2, y1, y2;
        String[] x1_x2 = a.split(",");
        String[] y1_y2 = b.split(",");
        x1 = Integer.parseInt(x1_x2[0]);
        x2 = Integer.parseInt(x1_x2[1]);
        y1 = Integer.parseInt(y1_y2[0]);
        y2 = Integer.parseInt(y1_y2[1]);
        if (x1 < y1) {
            return -1;
        }
        if (y1 < x1) {
            return 1;
        }
        if (x2 < y2) {
            return -1;
        }
        if (x2 > y2) {
            return 1;
        }
        return 0;
    }

    public static int getRandomNumber(int a, int b) {
        return (int) (Math.random() * (b - a) + a);
    }

    public Game(int nrPlayers, int n) {
        this.nrPlayers = nrPlayers;
        this.n = n;
        this.players = new ArrayList<>();

        //initializez tabela de joc
        this.availableTokens = new TreeMap<>(Game::compareByToken);
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                int value = getRandomNumber(1, MAX_VALUE + 1);
                String key = i + "," + j;
                this.availableTokens.put(key, value);
            }
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

    //metoda ce ma ajuta sa determin circuitele in graful neorientat reprezentat de jetoanele alese de un jucator
    private void dfs(int curNode, int prevNode, int[] color, int[] mark, int prev[], Map<Integer, List<Integer>> adjacencyList,
            List<List<Integer>> solution) {
        if (color[curNode] == 2) {
            return;
        }

        if (color[curNode] == 1) {
            Game.cycleNumber++;
            int node = prevNode;
            mark[node] = Game.cycleNumber;
            List<Integer> cycle = new ArrayList<>();
            cycle.add(node);

            while (node != curNode) {
                node = prev[node];
                cycle.add(node);
                mark[node] = Game.cycleNumber;
            }
            solution.add(cycle);
            return;
        }
        prev[curNode] = prevNode;
        color[curNode] = 1;
        if (adjacencyList.containsKey(curNode)) {
            var neighbours = adjacencyList.get(curNode);
            for (int node : neighbours) {
                if (node == prevNode) {
                    continue;
                }
                dfs(node, curNode, color, mark, prev, adjacencyList, solution);
            }
        }
        color[curNode] = 2;
    }

    //metoda prin care imi construiesc lista de adiacenta corespunzatoare grafului reprezentat prin jetoanele 
    //alese de jucator si apelez metoda dfs(...)
    private List<List<Integer>> determineSequences(Map<String, Integer> choosenTokens) {
        Map<Integer, List<Integer>> adjacencyList = new TreeMap<>();
        for (String key : choosenTokens.keySet()) {
            String[] nodes = key.split(",");
            int a = Integer.parseInt(nodes[0]);
            int b = Integer.parseInt(nodes[1]);
            List<Integer> neighbours;

            if (adjacencyList.containsKey(a)) {
                neighbours = adjacencyList.get(a);
            } else {
                neighbours = new ArrayList<>();
            }
            neighbours.add(b);
            adjacencyList.put(a, neighbours);

            if (adjacencyList.containsKey(b)) {
                neighbours = adjacencyList.get(b);
            } else {
                neighbours = new ArrayList<>();
            }
            neighbours.add(a);
            adjacencyList.put(b, neighbours);
        }
        int[] mark = new int[this.n + 1];
        int[] prev = new int[this.n + 1];
        int[] colour = new int[this.n + 1];
        Game.cycleNumber = 0;
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            prev = new int[this.n + 1];
            if (colour[i] == 0) {
                dfs(i, 0, colour, mark, prev, adjacencyList, solution);
            }
        }
        return solution;
    }

    public boolean registerPlayer(Player player) {
        if (players.size() < this.nrPlayers) {
            players.add(player);
            return true;
        }
        return false;
    }

    //incep jocul si stabilesc la finalul jocului clasamentul
    public void startGame() {
        if (players.size() == this.nrPlayers) {
            List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < this.nrPlayers; ++i) {
                players.get(i).setGame(this);
                players.get(i).setIdentifier(i);
                threads.add(new Thread(players.get(i)));
                threads.get(i).start();
            }
            
            for (Thread thread : threads)
                try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            //de aici incolo jocul s-a terminat
            System.out.println("Game is finished!");
            for (Player p : players) {
                var sequences = this.determineSequences(p.getChoosenTokens());
                p.setSequences(sequences);
                p.calculateScore();
            }
            players.sort(Collections.reverseOrder(Player::compareByScore));
            System.out.println("Clasament:");
            for (Player p : players) {
                System.out.println(p);
            }

        }
    }
}
