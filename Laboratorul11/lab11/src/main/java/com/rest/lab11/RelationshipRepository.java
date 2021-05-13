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
public interface RelationshipRepository extends CrudRepository<Relationship, Long>{
    
    public Relationship findById(long id);
    
    public List<Relationship> findByPerson1(Person person1);
    
    public List<Relationship> findByPerson2(Person person2);
    
}
