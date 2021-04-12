/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul7;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Radu
 */
public class ManualPlayer extends Player {
    
    public ManualPlayer(String name)
    {
        super(name);
    }
    
    @Override
    public boolean chooseToken() {
        Scanner s = new Scanner(System.in);
        boolean validChoose = false;
        System.out.println(this.name + "! It's your turn!\n"
                + "Available commands:\ngetAvailableTokens\nchoose x,y\ngetMyTokens");
        if(this.game.getAvailableTokens().size()==0)
        {
            System.out.println("There are no tokens left on the table.");
        }
        else
        {
        while(!validChoose)
        {
            String line = s.nextLine();
            line = line.trim().replaceAll(" +", " ");
            List<String> commandSyntax = Arrays.asList(line.split(" "));
            switch(commandSyntax.get(0))
            {
                case "getAvailableTokens":
                    if(commandSyntax.size() > 1)
                        System.out.println("Invalid syntax!");
                    else
                        System.out.println(this.game.getAvailableTokens());
                    break;
                case "getMyTokens":
                    if(commandSyntax.size() > 1)
                        System.out.println("Invalid syntax!");
                    else
                        System.out.println(this.choosenTokens);
                    break;
                case "choose":
                    if(commandSyntax.size() == 1 || commandSyntax.size() >= 3)
                        System.out.println("Invalid syntax!");
                    else
                    {
                        String token = commandSyntax.get(1);
                        var availableTokens = this.game.getAvailableTokens();
                        if (availableTokens.containsKey(token))
                        {
                           int value = availableTokens.get(token);
                           this.choosenTokens.put(token, value);
                           availableTokens.remove(token);
                           validChoose = true;
                        }
                        else
                            System.out.println("This token has already been taken or is incorrect! Choose another one!");
                    }
                    break;
                default:
                    System.out.println("Command not recognised!");
            }
            
        }
        }
        return true;
    }
    
}
