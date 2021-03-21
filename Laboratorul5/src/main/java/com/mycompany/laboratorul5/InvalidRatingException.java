/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

/**
 *
 * @author Radu
 */
public class InvalidRatingException extends RuntimeException{
    
    public InvalidRatingException(int rating)
    {
        super("Invalid rating: " + rating);
    }
    
}
