/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4;
import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author Radu
 */
public class HardProblem extends Problem {
    
    private Map<School,List<Student>> schPrefMap;
    public HardProblem(Map<Student,List<School>> stdPrefMap, Map<School,List<Student>> schPrefMap )
    {
        this.stdPrefMap = stdPrefMap;
        this.schPrefMap = schPrefMap;
    }
    
    public Set<School> querry2(Student student)
    {
        var x = schPrefMap.entrySet().stream().filter(map -> map.getValue().get(0).equals(student)).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue())).keySet();
        return x;
        
    }
    
    

    

    
    
    
}
