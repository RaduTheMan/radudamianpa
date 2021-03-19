/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4.algorithms;

import com.mycompany.laboratorul4.problems.EasyProblem;
import com.mycompany.laboratorul4.problems.Solution;
import com.mycompany.laboratorul4.domain.School;
import com.mycompany.laboratorul4.domain.Student;
import java.util.*;

/**
 *
 * @author Radu
 */
public class EasyAlgorithm implements Algorithm {

    private EasyProblem pb;

    public EasyAlgorithm(EasyProblem pb) {
        this.pb = pb;
    }

    @Override
    public Solution solve() { //algoritm ce realizeaza matching-ul pe baza notelor studentilor
        Map<Student, School> tempSolution = new HashMap<>();
        Set<Student> studentsSet = this.pb.getStdPrefMap().keySet();
        int nrStudents = studentsSet.size();

        List<Student> studentsList = Arrays.asList(studentsSet.toArray(new Student[nrStudents]));
        studentsList.sort(Student::compareByGrade);

        for (School h : this.pb.getSchools()) {
            System.out.println("School: " + h + "; Capacity: " + h.getCapacity());
        }
        for (Student s : studentsList) {
            System.out.println("Student name: " + s + "; Grade: " + s.getGrade());

            List<School> preferences = this.pb.getStdPrefMap().get(s);
            var tempSchools = tempSolution.values();
            for (School h : preferences) {
                int tempCapacity = Collections.frequency(tempSchools, h);
                if (tempCapacity < h.getCapacity()) {
                    tempSolution.put(s, h);
                    break;
                }
            }
        }

        Solution solution = new Solution(tempSolution);
        return solution;

    }

}
