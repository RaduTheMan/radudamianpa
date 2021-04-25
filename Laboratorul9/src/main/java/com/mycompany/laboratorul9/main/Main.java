/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.main;

import com.mycompany.laboratorul9.entityclasses.Actor;
import com.mycompany.laboratorul9.singleton.jpa.EntityManagerSingleton;


/**
 *
 * @author Radu
 */
public class Main {

    public static void main(String[] args) {

      testCreateActor();
      
        
    }
    
    private static void testCreateActor()
    {
      EntityManagerSingleton ems = EntityManagerSingleton.getInstance();
      ems.createEntityManager();
      ems.getEntityManager().getTransaction().begin();
      Actor actor = new Actor();
      actor.setIdActor((short)20);
      actor.setFirstName("Radu");
      actor.setLastName("Damian");
      ems.getEntityManager().persist(actor);
      ems.getEntityManager().getTransaction().commit();
      ems.closeEntityManager();
      ems.closeEntityManagerFactory();
      System.out.println(actor);
    }
    
}
