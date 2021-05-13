/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Radu
 */
public interface PersonRepository extends CrudRepository<Person, Long>{
    
    public List<Person> findByName(String name);
    
    public Person findById(long id);
    
}
