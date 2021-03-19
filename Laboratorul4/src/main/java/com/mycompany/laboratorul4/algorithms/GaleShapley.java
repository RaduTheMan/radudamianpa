/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4.algorithms;

import com.mycompany.laboratorul4.domain.School;
import com.mycompany.laboratorul4.domain.Student;
import com.mycompany.laboratorul4.problems.HardProblem;
import com.mycompany.laboratorul4.problems.Solution;
import java.util.*;

/**
 *
 * @author Radu
 */
public class GaleShapley implements Algorithm {
    
    private HardProblem pb;
    
    public GaleShapley(HardProblem pb)
    {
        this.pb = pb;
    }
    
    @Override
    public Solution solve()
    {
        Map<Student, School> tempSolution = new HashMap<>(); //solutie temporara
        Set<Student> studentsSet = this.pb.getStdPrefMap().keySet();
        int nrStudents = studentsSet.size();
        List<Student> studentsList = Arrays.asList(studentsSet.toArray(new Student[nrStudents]));
        
        //construiesc o mapa in care tin evidenta "propunerilor" temporare ale fiecarei scoli
        //acestea sunt codificate astfel: 0 - inca nu a fost facuta propunerea; 1 - propunerea a fost acceptata; 
        //-1 - propunerea nu a fost acceptata;
        Map<School,List<Integer>> schoolsProposals = new TreeMap<>();
        for(School h : this.pb.getSchPrefMap().keySet())
        {
            int nrStudentsOf_h = this.pb.getSchPrefMap().get(h).size();
            List<Integer> aux = Arrays.asList(new Integer[nrStudentsOf_h]);
            Collections.fill(aux, 0);
            schoolsProposals.put(h, aux);
            System.out.println("School: "+ h + "; Capacity: " + h.getCapacity());
        }
        
        //construiesc o mapa in care tin evidenta modificarilor capacitatilor fiecarei scoli
        Map<School, Integer> schoolsCapacities = new TreeMap<>();
        for(School h : this.pb.getSchPrefMap().keySet())
        {
            schoolsCapacities.put(h, h.getCapacity());
        }
        
        //initializez solutia temporara
        for(Student s : studentsList)
        {
           tempSolution.put(s, null);
        }
        
        boolean isDone = false;
        while(!isDone)
        {
            isDone = true;
            for(School h : this.pb.getSchPrefMap().keySet())
            {
                if(schoolsCapacities.get(h) > 0)
                {
                    List<Integer> currentSchoolProposals = schoolsProposals.get(h);
                    for(Integer status : currentSchoolProposals)
                    {
                        if (status == 0) //scoala curenta h face o propunere unui student
                        {
                            isDone = false;
                            int indexStudent = currentSchoolProposals.indexOf(status);
                            Student targetedStudent = this.pb.getSchPrefMap().get(h).get(indexStudent);
                            if(tempSolution.get(targetedStudent) == null) //daca studentul ofertat nu este admis inca la niciun liceu
                            {
                                tempSolution.put(targetedStudent, h);
                                schoolsCapacities.put(h, schoolsCapacities.get(h)-1);
                                currentSchoolProposals.set(indexStudent, 1);
                                schoolsProposals.put(h, currentSchoolProposals);
                            }
                            else
                            {
                                School currentSelectedSchool = tempSolution.get(targetedStudent);
                                List<School> targetedStudentPreferences = this.pb.getStdPrefMap().get(targetedStudent);
                                int indexOfPotentialSchool = targetedStudentPreferences.indexOf(h);
                                int indexOfCurrentSelectedSchool = targetedStudentPreferences.indexOf(currentSelectedSchool);
                                if(indexOfPotentialSchool < indexOfCurrentSelectedSchool && indexOfPotentialSchool != -1)
                                {
                                    tempSolution.put(targetedStudent, h);
                                    currentSchoolProposals.set(indexStudent, 1);
                                    List<Student> oldSchoolPreferences = this.pb.getSchPrefMap().get(currentSelectedSchool);
                                    List<Integer> oldSchoolProposals = schoolsProposals.get(currentSelectedSchool);
                                    int indexStudentOldSchool = oldSchoolPreferences.indexOf(targetedStudent);
                                    oldSchoolProposals.set(indexStudentOldSchool, -1);
                                    schoolsProposals.put(currentSelectedSchool, oldSchoolProposals);
                                    schoolsCapacities.put(currentSelectedSchool, schoolsCapacities.get(currentSelectedSchool)+1);
                                    schoolsCapacities.put(h, schoolsCapacities.get(h)-1);
                                }
                                else
                                {
                                    currentSchoolProposals.set(indexStudent, -1);
                                    schoolsProposals.put(h, currentSchoolProposals);
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        Solution solution = new Solution(tempSolution);
        return solution;
    }
    
}
