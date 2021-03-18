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
public abstract class Problem {
    protected Map<Student,List<School>> stdPrefMap;
    public Map<Student,List<School>> getStdPrefMap()
    {
        return new HashMap<>(stdPrefMap);
    }
    public void querry1(List<School> schools)
    {
        stdPrefMap.entrySet().stream().filter(map -> map.getValue().containsAll(schools)).forEach(System.out::println);
    }
    
}
