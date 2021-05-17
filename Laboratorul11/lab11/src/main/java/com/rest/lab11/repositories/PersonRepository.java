/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11.repositories;

import com.rest.lab11.entities.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Radu
 */
public interface PersonRepository extends CrudRepository<Person, Long>{
    
    public Person findByName(String name);
    
    public Person findById(long id);
    
}
