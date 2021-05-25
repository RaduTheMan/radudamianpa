/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theproject;

import org.junit.jupiter.api.Test;


/**
 *
 * @author Radu
 */
public class MyProgram {

    public int y = 15;
    
    @Test 
    public static void m1() {
        System.out.println("I'm m1");
    }

    public static void m2() {
    }

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public static void m5() {
        System.out.println("I'm m5");
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }
    
    @Test
    public void m9(int x)
    {
        System.out.println(x+5);
    }
}
