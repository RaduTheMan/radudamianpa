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
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
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
@Table(name = "CHARTS")
@NamedQueries({
    @NamedQuery(name = "Chart.findAll", query = "SELECT c FROM Chart c"),
    @NamedQuery(name = "Chart.findById", query = "SELECT c FROM Chart c WHERE c.id = :id"),
    @NamedQuery(name = "Chart.findByName", query = "SELECT c FROM Chart c WHERE c.name = :name"),
    @NamedQuery(name = "Chart.findByCreationDate", query = "SELECT c FROM Chart c WHERE c.creationDate = :creationDate")})
@AttributeOverride(name = "id", column = @Column(name = "ID_CHART"))
@AttributeOverride(name = "name", column = @Column(name = "NAME"))
public class Chart extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @JoinTable(name = "CHART_MOVIE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_CHART", referencedColumnName = "ID_CHART")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    @OrderBy("score DESC")
    private List<Movie> movieList;

    public Chart() {
    }
    
    public void setId(EntityManagerSingleton ems)
    {
        ems.createEntityManager();
        Query q = ems.getEntityManager().createNativeQuery("SELECT chart_seq.NEXTVAL FROM dual");
        long solution = ((BigDecimal) q.getSingleResult()).longValue();
        this.id = solution;
        ems.closeEntityManager();
    }

    public Chart(Long idChart) {
        this.id = idChart;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        if (!(object instanceof Chart)) {
            return false;
        }
        Chart other = (Chart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.jpa.entityclasses.Charts[ idChart=" + id + " ]";
    }
    
}
