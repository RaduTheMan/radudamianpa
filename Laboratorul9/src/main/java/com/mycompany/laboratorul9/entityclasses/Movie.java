/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.entityclasses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Movie.findByIdMovie", query = "SELECT m FROM Movie m WHERE m.idMovie = :idMovie"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByReleaseDate", query = "SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Movie.findByDuration", query = "SELECT m FROM Movie m WHERE m.duration = :duration"),
    @NamedQuery(name = "Movie.findByScore", query = "SELECT m FROM Movie m WHERE m.score = :score")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MOVIE")
    private Short idMovie;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;
    @Column(name = "DURATION")
    private Serializable duration;
    @Column(name = "SCORE")
    private Short score;
    @ManyToMany(mappedBy = "movieList")
    private List<Director> directorList;
    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actorList;
    @ManyToMany(mappedBy = "movieList")
    private List<Genre> genreList;

    public Movie() {
    }

    public Movie(Short idMovie) {
        this.idMovie = idMovie;
    }

    public Short getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Short idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Serializable getDuration() {
        return duration;
    }

    public void setDuration(Serializable duration) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovie != null ? idMovie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.idMovie == null && other.idMovie != null) || (this.idMovie != null && !this.idMovie.equals(other.idMovie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Movie[ idMovie=" + idMovie + " ]";
    }
    
}
