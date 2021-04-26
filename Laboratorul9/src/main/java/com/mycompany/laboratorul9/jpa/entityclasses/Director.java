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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Radu
 */
@Entity
@Table(name = "DIRECTORS")
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
    @NamedQuery(name = "Director.findById", query = "SELECT d FROM Director d WHERE d.id = :id"),
    @NamedQuery(name = "Director.findByName", query = "SELECT d FROM Director d WHERE d.name = :name")})
@AttributeOverride(name = "id", column = @Column(name = "ID_DIRECTOR"))
@AttributeOverride(name = "name", column = @Column(name = "NAME"))
public class Director extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinTable(name = "DIRECTOR_MOVIE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_DIRECTOR", referencedColumnName = "ID_DIRECTOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    private List<Movie> movieList;

    public Director() {   
    }
    
    public void setId(EntityManagerSingleton ems)
    {
        ems.createEntityManager();
        Query q = ems.getEntityManager().createNativeQuery("SELECT director_seq.NEXTVAL FROM dual");
        long solution = ((BigDecimal) q.getSingleResult()).longValue();
        this.id = solution;
        ems.closeEntityManager();
    }

    public Director(Long idDirector) {
        this.id = idDirector;
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
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Director[ idDirector=" + id + " ]";
    }
    
}
