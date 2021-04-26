/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9;

import com.mycompany.laboratorul9.jpa.entityclasses.Actor;
import com.mycompany.laboratorul9.jpa.entityclasses.Genre;
import com.mycompany.laboratorul9.jpa.entityclasses.Movie;
import com.mycompany.laboratorul9.jpa.repoclasses.ActorDaoImpl;
import com.mycompany.laboratorul9.jpa.repoclasses.GenreDaoImpl;
import com.mycompany.laboratorul9.jpa.repoclasses.MovieDaoImpl;
import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.Query;

/**
 *
 * @author Radu
 */
public class ImportData {

    String moviesFile = "e:/imdb_dataset/IMDb movies.csv";
    final int MAX_MOVIES = 30000;
    final int MAX_ACTORS_PER_MOVIE = 5;
    

    public ImportData(EntityManagerSingleton ems) {

        try {
            CSVReader reader = new CSVReader(new FileReader(moviesFile));
            List<String[]> r = reader.readAll();
            String[] columns = r.get(0);
            Map<String, Integer> attributes = new HashMap<>();
            for(int i=0; i< columns.length; ++i)
                attributes.put(columns[i], i);
            for(int i=1; i<=MAX_MOVIES; ++i)
            {
                String[] values = r.get(i);
                String title = values[attributes.get("title")];
                String releaseDate = values[attributes.get("date_published")];
                String duration = values[attributes.get("duration")];
                String score = values[attributes.get("avg_vote")];
                String actors = values[attributes.get("actors")];
                String directors = values[attributes.get("director")];
                String genres = values[attributes.get("genre")];
                String year = values[attributes.get("year")];
               
                
                float scoreFloat = Float.parseFloat(score);
                short scoreShort = (short)Math.round(scoreFloat);
                String[] dateComponents = releaseDate.split("-");
                if(dateComponents.length !=3)
                    releaseDate = year + "-01-01";
                
                Movie movie = new Movie();
                MovieDaoImpl movieFacade = new MovieDaoImpl(ems,Movie.class);
                movie.setId(ems);
                movie.setName(title);
                movie.setReleaseDate(Date.valueOf(releaseDate));
                movie.setScore(scoreShort);
                movie.setDuration(Duration.ofMinutes(Long.parseLong(duration)));
                movieFacade.create(movie);
                
                String[] actorsListStr = actors.split(",");
                ActorDaoImpl actorFacade = new ActorDaoImpl(ems, Actor.class);
                int cntr = 0;
                for(String actorStr : actorsListStr)
                {
                    Actor actor =  new Actor();
                    actor.setId(ems);
                    actor.setName(actorStr);
                    actorFacade.create(actor);
                    ems.createEntityManager();
                    ems.getEntityManager().getTransaction().begin();
                    Query q = ems.getEntityManager().createNativeQuery("INSERT INTO actor_movie_assoc VALUES(?, ?)");
                    q.setParameter(1, actor.getId());
                    q.setParameter(2, movie.getId());
                    q.executeUpdate();
                    ems.getEntityManager().getTransaction().commit();
                    ems.closeEntityManager();
                    cntr++;
                    if(cntr > this.MAX_ACTORS_PER_MOVIE)
                        break;
                }
                
                String[] genresListStr = genres.split(",");
                GenreDaoImpl genreFacade = new GenreDaoImpl(ems,Genre.class);
                for(String genreStr : genresListStr)
                {
                    genreStr = genreStr.strip();
                    Genre genre = genreFacade.findByName(genreStr);
                    if(genre == null)
                    {
                        genre = new Genre();
                        genre.setId(ems);
                        genre.setName(genreStr);
                        genreFacade.create(genre);
                    }
                    ems.createEntityManager();
                    ems.getEntityManager().getTransaction().begin();
                    Query q = ems.getEntityManager().createNativeQuery("INSERT INTO movie_genre_assoc VALUES(?, ?)");
                    q.setParameter(1, movie.getId());
                    q.setParameter(2, genre.getId());
                    q.executeUpdate();
                    ems.getEntityManager().getTransaction().commit();
                    ems.closeEntityManager();
                }
                
                
            }
//            r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (FileNotFoundException ex ) {
            System.out.println(ex);
        } catch (IOException | CsvException ex) {
            System.out.println(ex);
        }

    }
}
