/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4;

import java.util.*;

/**
 *
 * @author Radu
 */
public class EasyProblem extends Problem {
    
    private List<School> schools;
    public EasyProblem(Map<Student,List<School>> stdPrefMap, List<School> schools)
    {
        this.stdPrefMap = stdPrefMap;
        this.schools = schools;
    }

    public List<School> getSchools() {
        return new ArrayList<>(schools);
    }
    
    
}
