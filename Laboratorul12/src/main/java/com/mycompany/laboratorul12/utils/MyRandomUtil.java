/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul12.utils;

/**
 *
 * @author Radu
 */
public class MyRandomUtil {

    public static Integer generateIntegerValue(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static String generateStringValue(int maxLength) {
        StringBuilder solution = new StringBuilder();
        int solutionLength = generateIntegerValue(1, maxLength);
        for (int i = 0; i < solutionLength; ++i) {
            int asciiCode = generateIntegerValue((int) 'a', (int) 'z');
            solution.append((char) asciiCode);
        }
        return solution.toString();

    }

}
