/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul12;

/**
 *
 * @author Radu
 */
public class Main {

    public static final String INPUTFILE = "./input.txt";

    public static void main(String[] args) {
        MyTestFramework framework = new MyTestFramework();
        framework.beginTest(INPUTFILE);
    }
}
