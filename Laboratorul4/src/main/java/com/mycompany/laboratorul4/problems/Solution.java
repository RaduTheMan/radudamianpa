/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul4.problems;

import com.mycompany.laboratorul4.domain.School;
import com.mycompany.laboratorul4.domain.Student;
import java.util.*;

/**
 *
 * @author Radu
 */
public class Solution {

    private Map<Student, School> solution;

    public Solution(Map<Student, School> solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return solution.toString();
    }

}
