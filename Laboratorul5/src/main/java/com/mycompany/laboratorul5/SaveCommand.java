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
public class SaveCommand extends Command{
    
    private final String SYNTAX = "save <catalog -> name> <type:(xml | binary)>";
    
    public SaveCommand(Shell shell)
    {
        super("save",2);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        if(arguments.size() != this.numberOfArguments)
            throw new InvalidCommandException(SYNTAX);
        
        String name = arguments.get(0);
        String type = arguments.get(1);
        Catalog catalog = this.shell.findCatalogByName(name);
        if(catalog == null)
        {
            System.out.println("The catalog doesn't exist!");
        }
        else
        {
            boolean ok = false;
            if(type.equals("xml"))
            {
               CatalogUtil.saveWithXML(catalog);
               ok = true;
            }
            else if(type.equals("binary"))
            {
               CatalogUtil.saveWithBinary(catalog);
               ok = true;
            }
            else
                System.out.println("Choose to save in either {xml} or {binary} format!");
           if(ok == true)
                System.out.println("The command has completed successfully!");
        }
    }
}
