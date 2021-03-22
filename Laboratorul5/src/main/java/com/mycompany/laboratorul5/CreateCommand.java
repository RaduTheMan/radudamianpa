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
public class CreateCommand extends Command{
    
    private final String SYNTAX = "create <catalog(name,path)>";
    
    public CreateCommand(Shell shell)
    {
        super("create",2);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        if(arguments.size() != this.numberOfArguments)
            throw new InvalidCommandException(SYNTAX);
        Catalog catalog = new Catalog(arguments.get(0),arguments.get(1));
        if(this.shell.findCatalogByName(catalog.getName()) != null)
        {
            System.out.println("The catalog already exists!");
        }
        else
        {
        this.shell.addCatalog(catalog);
        System.out.println("The command has completed successfully!");
        }
    }
    
}
