/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.commands;

import java.util.List;

/**
 *
 * @author Radu
 */
public abstract class Command {

    protected final String NAME;
    protected Shell shell;
    protected final int numberOfArguments;

    public Command(String name, int numberOfArguments) {
        this.NAME = name;
        this.numberOfArguments = numberOfArguments;
    }

    public String getName() {
        return this.NAME;
    }

    public abstract void execute(List<String> arguments);
}
