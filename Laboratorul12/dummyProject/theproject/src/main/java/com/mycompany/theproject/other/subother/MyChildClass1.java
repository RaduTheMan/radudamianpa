/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theproject.other.subother;

import com.mycompany.theproject.other.MyClass1;

/**
 *
 * @author Radu
 */
public class MyChildClass1 extends MyClass1 {
    
    public int y;
    public MyChildClass1(int x, String y)
    {
        super(x);
        System.out.println("MESSAGE: " +y);
    }
    public MyChildClass1(int x)
    {
        super(x);
    }
    
}
