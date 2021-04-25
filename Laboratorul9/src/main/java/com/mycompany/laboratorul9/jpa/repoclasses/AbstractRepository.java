/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.repoclasses;

import com.mycompany.laboratorul9.jpa.entityclasses.AbstractEntity;
import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;
import javax.persistence.Query;

/**
 *
 * @author Radu
 */
public abstract class AbstractRepository<T extends AbstractEntity> {
    
    protected EntityManagerSingleton ems;
    protected Class<T> entityClass;
    
    
    
    public AbstractRepository(EntityManagerSingleton ems, Class<T> entityClass)
    {
        this.ems = ems;
        this.entityClass = entityClass;
    }
    
    public T findById(int id)
    {
        String entityName = entityClass.getSimpleName();
        ems.createEntityManager();
        Query q = ems.getEntityManager().createNamedQuery(entityName + ".findById");
        q.setParameter("id", id);
        T solution = (T) q.getSingleResult();
        ems.closeEntityManager();
        return solution;
    }
    
    public T findByName(String name)
    {
        String entityName = entityClass.getSimpleName();
        ems.createEntityManager();;
        Query q = ems.getEntityManager().createNamedQuery(entityName + ".findByName");
        q.setParameter("name", name);
        T solution = (T) q.getSingleResult();
        ems.closeEntityManager();
        return solution;
    }
    
    public void create(T entity)
    {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        ems.getEntityManager().persist(entity);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
    }
    
    
}
