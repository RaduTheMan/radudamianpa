/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4;

import java.util.stream.IntStream;
import java.util.*;

/**
 *
 * @author Radu
 */
public class Lab4 {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i)).toArray(School[]::new);

        List<Student> studentsList = new LinkedList<>();
        for(Student s : students)
        {
            studentsList.add(s);
        }
        
        studentsList.sort(Student::compareByName);
   
        Set<School> schoolsSet = new TreeSet<>();
        for(School h : schools)
        {
            schoolsSet.add(h);
        }
        
        Map<Student,List<School>> stdPrefMap = new HashMap<>();
        Map<School,List<Student>> schPrefMap = new TreeMap<>();
        
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0],schools[2]));
        
        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));
        
        System.out.println(stdPrefMap);
        System.out.println(schPrefMap);
    }

}
