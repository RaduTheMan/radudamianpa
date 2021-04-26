/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.entityclasses;

import com.mycompany.laboratorul9.jpa.converters.DurationConverter;
import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Radu
 */
@Entity
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByName", query = "SELECT m FROM Movie m WHERE m.name = :name"),
    @NamedQuery(name = "Movie.findByReleaseDate", query = "SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Movie.findByDuration", query = "SELECT m FROM Movie m WHERE m.duration = :duration"),
    @NamedQuery(name = "Movie.findByScore", query = "SELECT m FROM Movie m WHERE m.score = :score")})
@AttributeOverride(name = "id", column = @Column(name = "ID_MOVIE"))
@AttributeOverride(name = "name", column = @Column(name = "TITLE"))
public class Movie extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name = "DURATION")
    @Convert(converter = DurationConverter.class)
    private Duration duration;
    @Column(name = "SCORE")
    private Short score;
    @ManyToMany(mappedBy = "movieList")
    private List<Director> directorList;
    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actorList;
    @ManyToMany(mappedBy = "movieList")
    private List<Genre> genreList;
//    @ManyToMany(mappedBy = "movieSet")
//    private Set<Charts> chartsSet;

    public Movie() {
        
    }
    
    public void setId(EntityManagerSingleton ems)
    {
        ems.createEntityManager();
        Query q = ems.getEntityManager().createNativeQuery("SELECT movie_seq.NEXTVAL FROM dual");
        long solution = ((BigDecimal) q.getSingleResult()).longValue();
        this.id = solution;
        ems.closeEntityManager();
    }

    public Movie(Long idMovie) {
        this.id = idMovie;
    }
    
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }


    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
//     public Set<Charts> getChartsSet() {
//        return chartsSet;
//    }
//
//    public void setChartsSet(Set<Charts> chartsSet) {
//        this.chartsSet = chartsSet;
//    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Movie[ idMovie=" + id + " ]";
    }


   

    
}
