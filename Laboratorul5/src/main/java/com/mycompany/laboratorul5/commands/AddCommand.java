/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5.commands;

import com.mycompany.laboratorul5.domain.Catalog;
import com.mycompany.laboratorul5.domain.Movie;
import com.mycompany.laboratorul5.domain.Song;
import com.mycompany.laboratorul5.exceptions.InvalidCommandException;
import java.util.List;

/**
 *
 * @author Radu
 */
public class AddCommand extends Command {

    private final String SYNTAX = "add <catalog -> name> <item{song:(genre, name, path, rating)"
            + " | movie:(genre,name,path,releaseYear)}>";

    public AddCommand(Shell shell) {
        super("add", 6);
        this.shell = shell;
    }

    @Override
    public void execute(List<String> arguments) {
        if (arguments.size() != this.numberOfArguments) {
            throw new InvalidCommandException(SYNTAX);
        }

        String catalogName = arguments.get(0);
        Catalog catalog = this.shell.findCatalogByName(catalogName);
        if (catalog == null) {
            System.out.println("The catalog doesn't exist!");
        } else {
            String itemType = arguments.get(1);
            if (itemType.equals("song")) {
                var song = new Song(arguments.get(2), arguments.get(3), arguments.get(4), Integer.parseInt(arguments.get(5)));
                catalog.add(song);
            } else {
                var movie = new Movie(arguments.get(2), arguments.get(3), arguments.get(4), Integer.parseInt(arguments.get(5)));
                catalog.add(movie);
            }
            System.out.println("The command has completed successfully!");

        }
    }

}
