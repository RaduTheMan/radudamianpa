/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.main;

import com.mycompany.laboratorul9.problem.Algorithm;
import com.mycompany.laboratorul9.problem.GreedyAlgorithm;
import com.mycompany.laboratorul9.tools.ImportData;
import com.mycompany.laboratorul9.jpa.repoclasses.ActorDaoImpl;
import com.mycompany.laboratorul9.jpa.repoclasses.MovieDaoImpl;
import com.mycompany.laboratorul9.jpa.entityclasses.Actor;
import com.mycompany.laboratorul9.jpa.entityclasses.Chart;
import com.mycompany.laboratorul9.jpa.entityclasses.Director;
import com.mycompany.laboratorul9.jpa.entityclasses.Genre;
import com.mycompany.laboratorul9.jpa.entityclasses.Movie;
import com.mycompany.laboratorul9.jpa.repoclasses.ChartDaoImpl;
import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;
import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class Main {

    public static void main(String[] args) {

        EntityManagerSingleton ems = EntityManagerSingleton.getInstance();
        //testCreateActor(ems);
//      testCreateDirector(ems);
//      testCreateGenre(ems);
//      testCreateMovie(ems);
//      testCreateChart(ems);
//      testMethodsFromRepositories(ems);
//      testImportData(ems);
        var input = getFirst_n_Movies(100, ems);
        Algorithm algorithm = new GreedyAlgorithm(input);
        var solution = algorithm.solve();
        System.out.println(solution);
        ems.closeEntityManagerFactory();

    }

    private static List<Movie> getFirst_n_Movies(int n, EntityManagerSingleton ems) {
        MovieDaoImpl movieFacade = new MovieDaoImpl(ems, Movie.class);
        List<Movie> solution = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            Movie movie = movieFacade.findById(i);
            solution.add(movie);
        }
        return solution;
    }

    private static void testCreateActor(EntityManagerSingleton ems) {
        Actor actor = new Actor();
        actor.setId(ems);
        actor.setName("Radu Damian");
        System.out.println(actor);
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        ems.getEntityManager().persist(actor);
        ems.getEntityManager().getTransaction().commit();
    }

    private static void testCreateDirector(EntityManagerSingleton ems) {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        Director director = new Director((long) 20);
        director.setName("Ion Ion");
        ems.getEntityManager().persist(director);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
        System.out.println(director);

    }

    private static void testCreateGenre(EntityManagerSingleton ems) {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        Genre genre = new Genre((long) 17);
        genre.setName("Aventura");
        ems.getEntityManager().persist(genre);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
        System.out.println(genre);

    }

    private static void testCreateMovie(EntityManagerSingleton ems) {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        Movie movie = new Movie((long) 15);
        movie.setName("Avatar");
        movie.setScore((short) 7);
        movie.setReleaseDate(Date.valueOf("1997-03-10"));
        movie.setDuration(Duration.parse("PT1H30M"));
        ems.getEntityManager().persist(movie);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
        System.out.println(movie);

    }

    private static void testCreateChart(EntityManagerSingleton ems) {
        ems.createEntityManager();
        ems.getEntityManager().getTransaction().begin();
        Chart chart = new Chart((long) 7);
        chart.setName("underrated movies");
        chart.setCreationDate(Date.valueOf("2012-03-12"));
        ems.getEntityManager().persist(chart);
        ems.getEntityManager().getTransaction().commit();
        ems.closeEntityManager();
        System.out.println(chart);
    }

    private static void testMethodsFromRepositories(EntityManagerSingleton ems) {

//        MovieDaoImpl movieFacade = new MovieDaoImpl(ems, Movie.class);
//        System.out.println(movieFacade.findById(2).getDuration());
//        System.out.println(movieFacade.findByName("Airplane").getActorList().size());
//        
//        Movie movie = new Movie((short)15);
//        movie.setName("Avatar");
//        movie.setScore((short)7);
//        movie.setReleaseDate(Date.valueOf("1997-03-10"));
//        movie.setDuration(Duration.parse("PT1H30M"));
//        
//        ActorDaoImpl actorFacade = new ActorDaoImpl(ems, Actor.class);
//        System.out.println(actorFacade.findById(3).getName());
//        
//        movieFacade.create(movie);
        ChartDaoImpl chartFacade = new ChartDaoImpl(ems, Chart.class);
        var movies = chartFacade.findById(1).getMovieList();
        for (var movie1 : movies) {
            System.out.println(movie1.getName() + " " + movie1.getScore());
        }
        System.out.println(chartFacade.findById(1).getName());
    }

    private static void testImportData(EntityManagerSingleton ems) {
        ImportData tool = new ImportData(ems);
    }

}
