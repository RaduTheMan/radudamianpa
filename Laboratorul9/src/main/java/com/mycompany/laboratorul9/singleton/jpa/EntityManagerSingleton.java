/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.singleton.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Radu
 */
public class EntityManagerSingleton {
    
    private static EntityManagerSingleton instance = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private EntityManagerSingleton()
    {
        emf = Persistence.createEntityManagerFactory("com.mycompany_Laboratorul9_jar_1.0-SNAPSHOTPU");
    }
    
    public void createEntityManager()
    {
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return em;
    }
    
    public void closeEntityManager()
    {
        em.close();
    }
    
    public void closeEntityManagerFactory()
    {
        emf.close();
    }
    
    public static EntityManagerSingleton getInstance()
    {
        if(instance == null)
            instance = new EntityManagerSingleton();
        
        return instance;
    }
    
    
}
