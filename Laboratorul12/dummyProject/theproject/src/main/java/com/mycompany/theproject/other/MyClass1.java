/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theproject.other;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Radu
 */
public class MyClass1 {
    
    public static int x = 2;
    private int y,z;
    private String someStr;
    public int w;
    

    public MyClass1(int someValue)
    {
        w = someValue;
        y=z=0;
        someStr = "lalala";
    }
    
    @Test
    public static void printSuccessor(int x)
    {
        System.out.println(x+1);
    }
    
    @Test 
    public static void printSumThreeNumbers(int x, int y, int z)
    {
        int sum = x + y + z;
        System.out.println("x+y+z: " + sum);
    }
    
    @Test
    public static void printMessage(String message)
    {
        System.out.println(message);
    }
    
    @Test
    public void printSomeStr()
    {
        System.out.println(someStr);
    }
    
    @Test
    public void printW()
    {
        System.out.println(w);
    }
    
    public int addSomething()
    {
        return y+z;
    }
    
}
