/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.problem;

import com.mycompany.laboratorul9.jpa.entityclasses.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Radu
 */
public abstract class Algorithm {

    protected List<Movie> input;
    protected List<Pair> graph = new ArrayList<>();

    public Algorithm(List<Movie> input) {
        this.input = input;

    }

    protected boolean areRelated(Pair pair) {
        Movie firstMovie = pair.getFirstMovie();
        Movie secondMovie = pair.getSecondMovie();
        var firstMovieDirectorList = firstMovie.getDirectorList();
        var secondMovieDirectorList = secondMovie.getDirectorList();
        return !Collections.disjoint(firstMovieDirectorList, secondMovieDirectorList);
    }

    protected boolean areAdjacent(Pair firstPair, Pair secondPair) {
        Set<Movie> nodes = new HashSet<>();
        nodes.add(firstPair.getFirstMovie());
        nodes.add(firstPair.getSecondMovie());
        nodes.add(secondPair.getFirstMovie());
        nodes.add(secondPair.getSecondMovie());
        if (nodes.size() < 4) {
            return true;
        }
        return false;
    }

    protected void buildGraph() {
        for (int i = 0; i < input.size() - 1; ++i) {
            for (int j = i + 1; j < input.size(); ++j) {
                Pair pair = new Pair(input.get(i), input.get(j));
                if (this.areRelated(pair)) {
                    graph.add(pair);
                }
            }
        }
    }

    public abstract Solution solve();
}
