/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Radu
 */
@Entity
@Table(name = "PERSONS")
public class Person {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name="person_generator", sequenceName = "person_seq", allocationSize = 1)
    private Long id;
    private String name;
    
    //TO DO: write correct annotation
    
    @ManyToMany
    @JoinTable(name = "RELATIONSHIPS", joinColumns = {@JoinColumn(name="ID_PERSON1", referencedColumnName="ID")}, 
            inverseJoinColumns = {@JoinColumn(name="ID_PERSON2", referencedColumnName="ID")} )
    @JsonIgnore
    private List<Person> friendsRight;
    
    @ManyToMany
    @JoinTable(name = "RELATIONSHIPS", joinColumns = {@JoinColumn(name="ID_PERSON2", referencedColumnName="ID")}, 
            inverseJoinColumns = {@JoinColumn(name="ID_PERSON1", referencedColumnName="ID")} )
    @JsonIgnore
    private List<Person> friendsLeft;
    
    protected Person() {}
    
    public Person(String name)
    {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<Person> getFriends() {
        List<Person> friends = new ArrayList<>(friendsLeft);
        friends.addAll(friendsRight);
        return friends;
    }
    

//    @Override
//    public String toString() {
//        return "Person{" + "idddd=" + id + ", name=" + name + "}";
//    }
    
    
    
    
}
