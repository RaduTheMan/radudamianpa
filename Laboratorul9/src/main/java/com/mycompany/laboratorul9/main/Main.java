/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.main;

import com.mycompany.laboratorul9.singleton.jpa.EntityManagerSingleton;


/**
 *
 * @author Radu
 */
public class Main {

    public static void main(String[] args) {

      EntityManagerSingleton ems = EntityManagerSingleton.getInstance();
      ems.createEntityManager();
      System.out.println(ems.getEntityManager().toString());
      
        
    }
    
}
