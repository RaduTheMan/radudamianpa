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
public abstract class Algorithm {

    protected Problem pb;
    protected int supplyTemp[];
    protected int demandTemp[];
    protected int x[][];

    public abstract Solution solve();

}
