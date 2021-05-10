/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
        if(this.parameters.size() >= 2)
        {
            Person user = new Person(this.parameters.get(this.parameters.size()-1));
            Set<Person> friends = new HashSet<>();
            for(int i=0;i<this.parameters.size() - 1; ++i)
            {
                Person person = new Person(this.parameters.get(i));
                if(!socialNetwork.existsUser(person))
                    return "Friends weren't added! At least one of them doesn't exist!";
                friends.add(person);
            }
            this.socialNetwork.addFriendstoUser(user, friends);
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
        if(components.length - 2 == 0)
            return false;
        this.parameters = new LinkedList<>(Arrays.asList(components));
        this.parameters.remove(0);
        return true;
    }
    
}
