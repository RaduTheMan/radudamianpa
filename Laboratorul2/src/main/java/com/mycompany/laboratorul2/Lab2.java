/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul2;

/**
 *
 * @author Radu
 */
public class Lab2 {

    public static void main(String[] args) {
        Problem pb = new Problem(5, 5);
        int supply[] = new int[]{10, 35, 25};
        int demand[] = new int[]{20, 25, 25};
        int cost[][] = new int[][]{{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        Source source1 = new Factory("S1");
        Source source2 = new Warehouse("S2");
        Source source3 = new Warehouse("S3");
        Destination destination1 = new Destination("D1");
        Destination destination2 = new Destination("D2");
        Destination destination3 = new Destination("D3");
        pb.addSource(source1);
        pb.addSource(source2);
        pb.addSource(source3);
        pb.addDestination(destination1);
        pb.addDestination(destination2);
        pb.addDestination(destination3);
        pb.setDemand(demand);
        pb.setSupply(supply);
        pb.setCost(cost);
        System.out.println(pb);

    }

}
