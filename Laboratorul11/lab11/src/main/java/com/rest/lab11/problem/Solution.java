/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11.problem;

import com.rest.lab11.entities.Person;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Radu
 */
public class Solution {

    Set<Person> importantPersons;

    public Solution(Set<Person> importantPersons) {
        this.importantPersons = importantPersons;
    }

    public Set<Person> getImportantPersons() {
        return new HashSet<>(importantPersons);
    }

    @Override
    public String toString() {
        return "Solution{" + "importantPersons=" + importantPersons + '}';
    }

}