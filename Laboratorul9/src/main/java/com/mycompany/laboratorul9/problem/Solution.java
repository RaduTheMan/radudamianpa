/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.problem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class Solution {

    List<Pair> playlist;

    public Solution(List<Pair> playlist) {
        this.playlist = playlist;
    }

    public List<Pair> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Pair> playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return playlist.toString();
    }

}
