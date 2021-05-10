/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Radu
 */
public abstract class Command {
    protected final String NAME;
    protected List<String> parameters = new ArrayList<>();
    protected final int numberOfParameters;

    public Command(String NAME, int numberOfParameters) {
        this.NAME = NAME;
        this.numberOfParameters = numberOfParameters;
    }
    
    public abstract String execute();
    public boolean setParametersFromRequest(String request)
    {
        String[] components = request.split(" ");
        if(!components[0].equals(this.NAME))
            return false;
        if(components.length - 1 != this.numberOfParameters )
            return false;
        this.parameters = new LinkedList<>(Arrays.asList(components));
        this.parameters.remove(0);
        return true;
    }
    
}
