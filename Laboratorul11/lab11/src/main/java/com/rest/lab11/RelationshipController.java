/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public long createRelationship(@RequestParam String name1, @RequestParam String name2)
    {
        Person person1 = personRepository.findByName(name1);
        Person person2 = personRepository.findByName(name2);
        if(person1 == null || person2 == null)
            return 0;
        if(person2.getId() == person1.getId())
            return 0;
        Relationship relationship = null;
        if(person2.getId() > person1.getId())
            relationship = new Relationship(person1, person2);
        else
            relationship = new Relationship(person2, person1);
        relationshipRepository.save(relationship);
        return relationship.getId();
    }
    
}
