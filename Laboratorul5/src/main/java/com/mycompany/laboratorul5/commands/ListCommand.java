/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.commands;

import com.mycompany.laboratorul5.domain.Catalog;
import com.mycompany.laboratorul5.exceptions.InvalidCommandException;
import java.util.List;

/**
 *
 * @author Radu
 */
public class ListCommand extends Command{
    
    private final String SYNTAX = "list <catalog -> name>";
    
    public ListCommand(Shell shell)
    {
        super("list",1);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
       if(arguments.size() != this.numberOfArguments)
            throw new InvalidCommandException(SYNTAX);
       String name = arguments.get(0);
       Catalog catalog = this.shell.findCatalogByName(name);
       if(catalog != null)
       {
           catalog.list();
           System.out.println("The command has completed successfully!");
       }
       else
            System.out.println("The catalog doesn't exist!");
    }
}
