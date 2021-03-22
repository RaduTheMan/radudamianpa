/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Radu
 */
public class Shell {
    private List<Catalog> catalogs = new ArrayList<>();
    private List<Command> commands = new ArrayList<>();
    
    public Shell()
    {
        commands.add(new AddCommand(this));
        commands.add(new ListCommand(this));
        commands.add(new SaveCommand(this));
        commands.add(new LoadCommand(this));
        commands.add(new PlayCommand(this));
        commands.add(new ReportCommand(this));
        commands.add(new CreateCommand(this));
    }
    
    private Command findCommandObj(String name)
    {
        for(Command command : commands)
        {
            if(command.getName().equals(name))
                return command;
        }
        return null;
    }
    
    public Catalog findCatalogByName(String name)
    {
        for(Catalog catalog : catalogs)
        {
            if(catalog.getName().equals(name))
                return catalog;
        }
        return null;
    }
    
    public void addCatalog(Catalog catalog)
    {
        catalogs.add(catalog);
    }
    public void run()
    {
       Scanner s = new Scanner(System.in);
       System.out.println("Welcome to the shell! Please enter a command:");
       boolean toQuit = false;
        while(toQuit == false)
       {
        String line = s.nextLine();
        line = line.trim().replaceAll(" +", " ");
        List <String> commandSyntax = Arrays.asList(line.split(" "));
        switch (commandSyntax.get(0))
        {
            case "add":
                Command command = findCommandObj("add");
                try
                {
                var subList = commandSyntax.subList(1, commandSyntax.size());
                command.execute(subList);
                }
                catch(InvalidCommandException e)
                {
                    System.err.println(e);
                }
                break;
            case "create":
                Command command2 = findCommandObj("create");
                try
                {
                var subList = commandSyntax.subList(1, commandSyntax.size());
                command2.execute(subList);
                }
                catch(InvalidCommandException e)
                {
                    System.err.println(e);
                }
                break;
            case "list":
                Command command3 = findCommandObj("list");
                try
                {
                var subList = commandSyntax.subList(1, commandSyntax.size());
                command3.execute(subList);
                }
                catch(InvalidCommandException e)
                {
                    System.err.println(e);
                }
                break;
            case "load":
                Command command4 = findCommandObj("load");
                try
                {
                var subList = commandSyntax.subList(1, commandSyntax.size());
                command4.execute(subList);
                }
                catch(InvalidCommandException e)
                {
                    System.err.println(e);
                }
                break;
            case "play":
                Command command5 = findCommandObj("play");
                try
                {
                var subList = commandSyntax.subList(1, commandSyntax.size());
                command5.execute(subList);
                }
                catch(InvalidCommandException e)
                {
                    System.err.println(e);
                }
                break;
            case "report":
                break;
            case "save":
                Command command7 = findCommandObj("save");
                try
                {
                var subList = commandSyntax.subList(1, commandSyntax.size());
                command7.execute(subList);
                }
                catch(InvalidCommandException e)
                {
                    System.err.println(e);
                }
                break;
            case "quit":
                toQuit = true;
                break;
            default:
                System.out.println("Command not recognised!");
        }
       }
    }
}
