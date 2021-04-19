/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul8;
import java.time.Duration;
/**
 *
 * @author Radu
 */
public class Main  {
    public static void main(String[] args) {
    
    //using the singleton
    DbConnection connection = DbConnection.getInstance();

    GenreDao genreDao = new GenreDaoImpl(connection);
    MovieDao movieDao = new MovieDaoImpl(connection);
//    Movie someMovie = movieDao.getMovie(1);
//    someMovie.setTitle("Car");
//    someMovie.setScore(4);
//    someMovie.setDuration(Duration.parse("PT1H45M"));
//    movieDao.updateMovie(someMovie);
//    
//    genreDao.deleteGenre(genreDao.getGenre(1));

    ActorDao actorDao = new ActorDaoImpl(connection);
    
//    Actor someActor = actorDao.getActor(2);
//    someActor.setFirstName("Ion");
//    actorDao.updateActor(someActor);
//    var actors = actorDao.getAllActors();
//    for(var actor : actors)
//    {
//        System.out.println(actor.getFirstName());
//    }

    DirectorDao directorDao = new DirectorDaoImpl(connection);
    var directors = directorDao.getAllDirectors();
    for(var director : directors)
            System.out.println(director.getLastName());
    
    Director someDirector = directorDao.getDirector(2);
    someDirector.setLastName("kkk");
    directorDao.updateDirector(someDirector);
   
    
    }
    
   
}
