/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Radu
 */
@Entity
@Table(name = "RELATIONSHIPS")
public class Relationship {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "relationship_generator")
    @SequenceGenerator(name="relationship_generator", sequenceName = "relationship_seq", allocationSize = 1)
    private Long id;
    
    @OneToOne
    @JoinColumn(name="id_person1", referencedColumnName = "ID")
    private Person person1;
    @OneToOne
    @JoinColumn(name="id_person2", referencedColumnName = "ID")
    private Person person2;
    
    protected Relationship() {}
    
    public Relationship(Person person1, Person person2)
    {
        this.person1 = person1;
        this.person2 = person2;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

//    @Override
//    public String toString() {
//        return "Relationship{" + "id=" + id + ", person1=" + person1 + ", person2=" + person2 + "}";
//    }
    
    
    
    
    
}
