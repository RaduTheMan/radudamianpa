/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.exceptions;

/**
 *
 * @author Radu
 */
public class InvalidYearException extends RuntimeException {

    public InvalidYearException(int year) {
        super("Invalid year: " + year);
    }

}
