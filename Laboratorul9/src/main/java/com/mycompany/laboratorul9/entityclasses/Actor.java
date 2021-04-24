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
@Table(name = "ACTORS")
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findByIdActor", query = "SELECT a FROM Actor a WHERE a.idActor = :idActor"),
    @NamedQuery(name = "Actor.findByFirstName", query = "SELECT a FROM Actor a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Actor.findByLastName", query = "SELECT a FROM Actor a WHERE a.lastName = :lastName")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ACTOR")
    private Short idActor;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinTable(name = "ACTOR_MOVIE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_ACTOR", referencedColumnName = "ID_ACTOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    private List<Movie> movieList;

    public Actor() {
    }

    public Actor(Short idActor) {
        this.idActor = idActor;
    }

    public Short getIdActor() {
        return idActor;
    }

    public void setIdActor(Short idActor) {
        this.idActor = idActor;
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
        hash += (idActor != null ? idActor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.idActor == null && other.idActor != null) || (this.idActor != null && !this.idActor.equals(other.idActor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Actor[ idActor=" + idActor + " ]";
    }
    
}
