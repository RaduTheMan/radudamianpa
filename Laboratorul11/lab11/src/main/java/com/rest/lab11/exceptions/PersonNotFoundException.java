/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11.exceptions;

/**
 *
 * @author Radu
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(long id) {
        super("Person with id " + id + " was not found in the database.");
    }
}
