/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.lab11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class Solution {
    List<Person> importantPersons;
    
    public Solution(List<Person> importantPersons)
    {
        this.importantPersons = importantPersons;
    }

    public List<Person> getImportantPersons() {
        return new ArrayList<>(importantPersons);
    }
    
    

    @Override
    public String toString() {
        return "Solution{" + "importantPersons=" + importantPersons + '}';
    }
    
    
}
