/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.util.List;

/**
 *
 * @author Radu
 */
public class ReportCommand extends Command{
    
    private final String SYNTAX = "report <catalog -> name>";
    
    public ReportCommand(Shell shell)
    {
       super("report",1);
       this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        if(arguments.size() != this.numberOfArguments)
            throw new InvalidCommandException(SYNTAX);
        
        
    }
}
