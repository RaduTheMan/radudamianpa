/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11.controllers;

import com.rest.lab11.entities.Person;
import com.rest.lab11.repositories.PersonRepository;
import com.rest.lab11.entities.Relationship;
import com.rest.lab11.repositories.RelationshipRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Radu
 */
@RestController
@RequestMapping("/relationships")
public class RelationshipController {
    
    @Autowired
    private RelationshipRepository relationshipRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @GetMapping
    public List<Relationship> getRelationships()
    {
        List<Relationship> solution = new ArrayList<>();
        var iterator = relationshipRepository.findAll();
       
        for(Relationship r : iterator)
        {
           solution.add(r);
        }
        return solution;
    }
    
    @PostMapping
    public ResponseEntity<String> createRelationship(@RequestParam String name1, @RequestParam String name2)
    {
        Person person1 = personRepository.findByName(name1);
        Person person2 = personRepository.findByName(name2);
        if(person1 == null || person2 == null)
            return new ResponseEntity<>("Either person '" + name1 + "' or person '" + name2 + "' (or both) don't exist in the database", HttpStatus.NOT_FOUND);
        if(person2.getId() == person1.getId())
            return new ResponseEntity<>("A person can't be friends with themselves.", HttpStatus.FORBIDDEN);
        Relationship relationship = null;
        if(person2.getId() > person1.getId())
        {
            var relationships = relationshipRepository.findByPerson1(person1);
            for (var relationshipObj : relationships)
            {
                if(relationshipObj.getPerson2().getName().equals(person2.getName())) {
                    return new ResponseEntity<>("This relationship already exists.", HttpStatus.FORBIDDEN);
                }
            }
              
            relationship = new Relationship(person1, person2);
        }
        else
        {
            var relationships = relationshipRepository.findByPerson1(person2);
            for (var relationshipObj : relationships)
            {
                if(relationshipObj.getPerson2().getName().equals(person1.getName())) {
                    return new ResponseEntity<>("This relationship already exists.", HttpStatus.FORBIDDEN);
                }
            }
            relationship = new Relationship(person2, person1);
        }
        relationshipRepository.save(relationship);
        return new ResponseEntity<>("Friendship between " + name1 + " and " + name2 + "added successfully.", HttpStatus.CREATED );
    }
    
}
