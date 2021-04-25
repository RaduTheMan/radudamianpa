/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.main;

import com.mycompany.laboratorul9.entityclasses.Actor;
import com.mycompany.laboratorul9.entityclasses.Director;
import com.mycompany.laboratorul9.entityclasses.Genre;
import com.mycompany.laboratorul9.entityclasses.Movie;
import com.mycompany.laboratorul9.singleton.jpa.EntityManagerSingleton;
import java.sql.Date;
import java.time.Duration;


/**
 *
 * @author Radu
 */
public class Main {

    public static void main(String[] args) {

      EntityManagerSingleton ems = EntityManagerSingleton.getInstance();
      testCreateActor(ems);
      testCreateDirector(ems);
      testCreateGenre(ems);
      testCreateMovie(ems);
      ems.closeEntityManagerFactory();
      
        
    }
    
    private static void testCreateActor(EntityManagerSingleton ems)
    {
      ems.createEntityManager();
      ems.getEntityManager().getTransaction().begin();
      Actor actor = new Actor();
      actor.setId((short)20);
      actor.setName("Radu Damian");
      ems.getEntityManager().persist(actor);
      ems.getEntityManager().getTransaction().commit();
      ems.closeEntityManager();
      System.out.println(actor);
    }
    
    private static void testCreateDirector(EntityManagerSingleton ems)
    {
      ems.createEntityManager();
      ems.getEntityManager().getTransaction().begin();
      Director director = new Director((short)20);
      director.setName("Ion Ion");
      ems.getEntityManager().persist(director);
      ems.getEntityManager().getTransaction().commit();
      ems.closeEntityManager();
      System.out.println(director);
      
    }
    
    private static void testCreateGenre(EntityManagerSingleton ems)
    {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        Genre genre = new Genre((short)17);
        genre.setName("Aventura");
        ems.getEntityManager().persist(genre);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
        System.out.println(genre);
        
    }
    
    private static void testCreateMovie(EntityManagerSingleton ems)
    {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        Movie movie = new Movie((short)15);
        movie.setName("Avatar");
        movie.setScore((short)7);
        movie.setReleaseDate(Date.valueOf("1997-03-10"));
        movie.setDuration(Duration.parse("PT1H30M"));
        ems.getEntityManager().persist(movie);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
        System.out.println(movie);
   
    }
    
}
