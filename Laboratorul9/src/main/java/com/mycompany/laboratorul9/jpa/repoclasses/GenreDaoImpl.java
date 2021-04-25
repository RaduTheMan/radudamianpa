/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.repoclasses;

import com.mycompany.laboratorul9.jpa.entityclasses.Genre;
import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;

/**
 *
 * @author Radu
 */
public class GenreDaoImpl extends AbstractRepository<Genre> {
    
    public GenreDaoImpl(EntityManagerSingleton ems, Class<Genre> entityClass) {
        super(ems, entityClass);
    }
    
}
