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
@Table(name = "DIRECTORS")
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
    @NamedQuery(name = "Director.findByIdDirector", query = "SELECT d FROM Director d WHERE d.idDirector = :idDirector"),
    @NamedQuery(name = "Director.findByFirstName", query = "SELECT d FROM Director d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "Director.findByLastName", query = "SELECT d FROM Director d WHERE d.lastName = :lastName")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DIRECTOR")
    private Short idDirector;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinTable(name = "DIRECTOR_MOVIE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_DIRECTOR", referencedColumnName = "ID_DIRECTOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    private List<Movie> movieList;

    public Director() {
    }

    public Director(Short idDirector) {
        this.idDirector = idDirector;
    }

    public Short getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Short idDirector) {
        this.idDirector = idDirector;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        hash += (idDirector != null ? idDirector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.idDirector == null && other.idDirector != null) || (this.idDirector != null && !this.idDirector.equals(other.idDirector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Director[ idDirector=" + idDirector + " ]";
    }
    
}
