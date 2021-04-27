/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.repoclasses;

import com.mycompany.laboratorul9.jpa.entityclasses.Movie;
import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;

/**
 *
 * @author Radu
 */
public class MovieDaoImpl extends AbstractRepository<Movie> {

    public MovieDaoImpl(EntityManagerSingleton ems, Class<Movie> entityClass) {
        super(ems, entityClass);
    }

}
