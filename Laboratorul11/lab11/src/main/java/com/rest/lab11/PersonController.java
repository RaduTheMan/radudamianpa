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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Person>> getPopular_k(@RequestParam int k, @RequestParam String type)
    {
        
        List<Person> persons = new ArrayList<>();
        var iterator = personRepository.findAll();
        for (Person p : iterator)
        {
            persons.add(p);
        }
        if(k>persons.size())
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        if(type.equals("MOST"))
          Collections.sort(persons, Collections.reverseOrder(Person::compareByNrFriends));
        else if(type.equals("LEAST"))
          Collections.sort(persons, Person::compareByNrFriends);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(persons.subList(0, k), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Person>> getFriends(@PathVariable long id)
    {
        Person person = personRepository.findById(id);
        if(person == null)
            throw new PersonNotFoundException(id);
        return new ResponseEntity<>(person.getFriends(),HttpStatus.OK);
    }
    
    @GetMapping("/important")
    public ResponseEntity<Solution> getImportantPersons()
    {
        List<Person> persons = this.getPersons();
        Algorithm algorithm = new LinearAlgorithm(persons);
        Solution solution = algorithm.solve();
        if(solution == null)
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(solution, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> createPerson(@RequestParam String name)
    {
        if(personRepository.findByName(name) != null)
            return new ResponseEntity<>("Person with name " + name + " already exists", HttpStatus.FORBIDDEN);
        Person person = new Person(name);
        personRepository.save(person);
        return new ResponseEntity<>("Person with name " + name + " added successfully in the database.", HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable long id, @RequestParam String name)
    {
        Person person = personRepository.findById(id);
        if(person == null)
            throw new PersonNotFoundException(id);
        person.setName(name);
        if(personRepository.findByName(name) != null)
            return new ResponseEntity<>("Person with name " + name + " already exists", HttpStatus.CONFLICT);
        personRepository.save(person);
        return new ResponseEntity<>("Person with id " + id + " was updated successfully.", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id)
    {
        Person person = personRepository.findById(id);
        if(person == null)
            throw new PersonNotFoundException(id);
        personRepository.delete(person);
        return new ResponseEntity<>("Person with id " + id + " was deleted successfully.", HttpStatus.OK);
    }
    
    
}
