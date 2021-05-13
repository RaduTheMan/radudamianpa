/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/popular")
    public List<Person> gePopular_k(@RequestParam int k, @RequestParam String type)
    {
        
        List<Person> persons = new ArrayList<>();
        var iterator = personRepository.findAll();
        for (Person p : iterator)
        {
            persons.add(p);
        }
        if(k>persons.size())
          return null;
        if(type.equals("MOST"))
          Collections.sort(persons, Collections.reverseOrder(Person::compareByNrFriends));
        else if(type.equals("LEAST"))
          Collections.sort(persons, Person::compareByNrFriends);
        else
            return null;
        return persons.subList(0, k);
    }
    
    @GetMapping("/{id}")
    public List<Person> getFriends(@PathVariable long id)
    {
        Person person = personRepository.findById(id);
        return person.getFriends();
    }
    
    @PostMapping
    public long createPerson(@RequestParam String name)
    {
        Person person = new Person(name);
        personRepository.save(person);
        return person.getId();
    }
    
    @PutMapping("/{id}")
    public boolean updatePerson(@PathVariable long id, @RequestParam String name)
    {
        Person person = personRepository.findById(id);
        if(person == null)
            return false;
        person.setName(name);
        personRepository.save(person);
        return true;
    }
    
    @DeleteMapping("/{id}")
    public boolean deletePerson(@PathVariable long id)
    {
        Person person = personRepository.findById(id);
        if(person == null)
            return false;
        personRepository.delete(person);
        return true;
    }
    
    
}
