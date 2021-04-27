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
@Table(name = "GENRES")
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
    @NamedQuery(name = "Genre.findById", query = "SELECT g FROM Genre g WHERE g.id = :id"),
    @NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE g.name = :name")})
@AttributeOverride(name = "id", column = @Column(name = "ID_GENRE"))
@AttributeOverride(name = "name", column = @Column(name = "NAME"))
@SequenceGenerator(name = "some_generator", sequenceName = "genre_seq", allocationSize = 1)
public class Genre extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinTable(name = "MOVIE_GENRE_ASSOC", joinColumns = {
        @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID_GENRE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")})
    @ManyToMany
    private List<Movie> movieList;

    public Genre() {
    }

    public void setId(EntityManagerSingleton ems) {
        ems.createEntityManager();
        Query q = ems.getEntityManager().createNativeQuery("SELECT genre_seq.NEXTVAL FROM dual");
        long solution = ((BigDecimal) q.getSingleResult()).longValue();
        this.id = solution;
        ems.closeEntityManager();
    }

    public Genre(Long idGenre) {
        this.id = idGenre;
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
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.laboratorul9.entityclasses.Genre[ idGenre=" + id + " ]";
    }

}
