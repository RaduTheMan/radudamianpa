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
public class PlayCommand extends Command{
    
    private final String SYNTAX = "play <catalog -> name> <item -> name>";
    
    public PlayCommand(Shell shell)
    {
        super("play",2);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        
    }
}
