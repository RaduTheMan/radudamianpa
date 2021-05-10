/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Radu
 */
public class FriendCommand extends Command {

    private SocialNetwork socialNetwork;
    
    public FriendCommand(SocialNetwork socialNetwork) {
        super("friend", 1);
        this.socialNetwork = socialNetwork;
    }

    @Override
    public String execute() {
        if(this.parameters.size() >= 1)
        {
            Person user = new Person(this.parameters.get(0));
            return "Friends added successfully!";
        }
        return "Parameters not initialised!";
    }
    
    @Override
    public boolean setParametersFromRequest(String request)
    {
        String[] components = request.split(" ");
        if(!components[0].equals(this.NAME))
            return false;
        if(components.length - 1 == 0)
            return false;
        this.parameters = new LinkedList<>(Arrays.asList(components));
        this.parameters.remove(0);
        return true;
    }
    
}
