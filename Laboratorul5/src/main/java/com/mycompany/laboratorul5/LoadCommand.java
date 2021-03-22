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
public class LoadCommand extends Command{
    
    private final String SYNTAX = "load <catalog -> path>";
    
    public LoadCommand(Shell shell)
    {
        super("load",1);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        if(arguments.size() != this.numberOfArguments)
            throw new InvalidCommandException(SYNTAX);
        
        String path = arguments.get(0);
        
        if(!(path.endsWith(".xml") || path.endsWith(".ser")))
            System.out.println("Path doesn't lead to an xml or binary file! ");
        else
        {
            Catalog catalog = null;
            if(path.endsWith(".xml"))
                catalog = CatalogUtil.loadWithXML(path);
            else
                catalog =CatalogUtil.loadWithBinary(path);
            this.shell.addCatalog(catalog);
            System.out.println("The command has completed successfully!");
        }
    }
}
