/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4.main;

import java.util.stream.IntStream;
import java.util.*;
import com.github.javafaker.Faker;
import com.mycompany.laboratorul4.algorithms.Algorithm;
import com.mycompany.laboratorul4.algorithms.EasyAlgorithm;
import com.mycompany.laboratorul4.algorithms.GaleShapley;
import com.mycompany.laboratorul4.problems.EasyProblem;
import com.mycompany.laboratorul4.problems.HardProblem;
import com.mycompany.laboratorul4.problems.Solution;
import com.mycompany.laboratorul4.domain.School;
import com.mycompany.laboratorul4.domain.Student;

/**
 *
 * @author Radu
 */
public class Lab4 {

    private static final int MAX_GRADE = 10;
    private static final int MAX_CAPACITY = 4;

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i)).toArray(School[]::new);

        Faker faker = new Faker();

        List<Student> studentsList = new LinkedList<>();
        for (Student s : students) {
            String name = faker.name().fullName();

            double tempGrade = 1 + Math.random() * (MAX_GRADE - 1);
            int auxGrade;
            double finalGrade;
            tempGrade *= 100;
            auxGrade = (int) tempGrade;
            finalGrade = auxGrade / 100.0;

            s.setName(name);
            s.setGrade(finalGrade); //medie random intre 1 si 10 cu 2 zecimale
            studentsList.add(s);
        }

        studentsList.sort(Student::compareByName);

        Set<School> schoolsSet = new TreeSet<>();
        for (School h : schools) {
            String schoolName = faker.university().name();
            int capacity = (int) (1 + Math.random() * MAX_CAPACITY);

            h.setName(schoolName);
            h.setCapacity(capacity);
            schoolsSet.add(h);
        }

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        Map<School, List<Student>> schPrefMap = new TreeMap<>();

        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        System.out.println(stdPrefMap);
        System.out.println(schPrefMap);
        System.out.println("");

        //test querry1
        EasyProblem pb1 = new EasyProblem(stdPrefMap, Arrays.asList(schools[0], schools[1], schools[2]));
        System.out.println("querry1: " + schools[0] + " - " + schools[2]);
        pb1.querry1(Arrays.asList(schools[2], schools[0]));
        System.out.println("");

        //test querry2
        HardProblem pb2 = new HardProblem(stdPrefMap, schPrefMap);
        System.out.println("querry2: " + students[3]);
        pb2.querry2(students[3]);
        System.out.println("");

        System.out.println("Solving with easy algorithm:");
        Algorithm alg1 = new EasyAlgorithm(pb1);
        Solution s1 = alg1.solve();
        System.out.println(s1);

        System.out.println("");
        System.out.println("Solving with Gale Shapley:");

        Algorithm alg2 = new GaleShapley(pb2);
        Solution s2 = alg2.solve();
        System.out.println(s2);

    }

}
