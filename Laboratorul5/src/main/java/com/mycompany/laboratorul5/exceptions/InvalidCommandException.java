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
public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String syntax) {
        super("Incorrect number of arguments!\nSyntax: " + syntax);
    }
}
