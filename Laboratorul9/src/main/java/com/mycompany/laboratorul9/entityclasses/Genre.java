/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.entityclasses;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Radu
 */
@Entity
@Table(name = "GENRES")
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
    @NamedQuery(name = "Genre.findByIdGenre", query = "SELECT g FROM Genre g WHERE g.idGenre = :idGenre"),
    @NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE g.name = :name")})
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GENRE")
    private Short idGenre;
    @Column(name = "NAME")
    private String name;
    @JoinTable(name = "MOVIE_GENRE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID_GENRE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    private List<Movie> movieList;

    public Genre() {
    }

    public Genre(Short idGenre) {
        this.idGenre = idGenre;
    }

    public Short getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Short idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenre != null ? idGenre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.idGenre == null && other.idGenre != null) || (this.idGenre != null && !this.idGenre.equals(other.idGenre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Genre[ idGenre=" + idGenre + " ]";
    }
    
}
