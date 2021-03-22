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
        if(arguments.size() != this.numberOfArguments)
            throw new InvalidCommandException(SYNTAX);
        
        String catalogName = arguments.get(0);
        String itemName = arguments.get(1);
        
        Catalog catalog = this.shell.findCatalogByName(catalogName);
        if(catalog == null)
            System.out.println("The catalog doesn't exist!");
        else 
        {
            Item item = catalog.findByName(itemName);
            if(item == null)
                System.out.println("The item doesn't exist!");
            else
            {
                CatalogUtil.view(item);
                System.out.println("The command has completed successfully!");
            }
        }
    }
}
