/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.entityclasses;

import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author Radu
 */
@Entity
@Table(name = "ACTORS")
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findById", query = "SELECT a FROM Actor a WHERE a.id = :id"),
    @NamedQuery(name = "Actor.findByName", query = "SELECT a FROM Actor a WHERE a.name = :name")})
@AttributeOverride(name = "id", column = @Column(name = "ID_ACTOR"))
@AttributeOverride(name = "name", column = @Column(name = "NAME"))
public class Actor extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinTable(name = "ACTOR_MOVIE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_ACTOR", referencedColumnName = "ID_ACTOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    private List<Movie> movieList;
   
    public Actor() {
    }
    
    public void setId(EntityManagerSingleton ems)
    {
        ems.createEntityManager();
        Query q = ems.getEntityManager().createNativeQuery("SELECT actor_seq.NEXTVAL FROM dual");
        long solution = ((BigDecimal) q.getSingleResult()).longValue();
        this.id = solution;
        ems.closeEntityManager();
    }

    public Actor(Long idActor) {
        this.id = idActor;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Actor[ idActor=" + id + " ]";
    }
    
}
