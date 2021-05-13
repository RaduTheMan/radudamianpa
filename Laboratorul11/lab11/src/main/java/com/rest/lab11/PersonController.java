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
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;
    
    @GetMapping
    public List<Person> getPersons()
    {
        List<Person> solution = new ArrayList<>();
        var iterator = personRepository.findAll();
       
        for(Person p : iterator)
        {
           solution.add(p);
        }
        return solution;
    }
    
    @PostMapping
    public long createPerson(@RequestParam String name)
    {
        Person person = new Person(name);
        personRepository.save(person);
        return person.getId();
    }
    
    
}
