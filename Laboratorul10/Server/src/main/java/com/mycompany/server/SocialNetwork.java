/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Radu
 */
public class SocialNetwork {
    private Set<Person> users = new HashSet<>();
    private Map<Person, Set<Person>> friendshipRelations = new HashMap<>();
    
    public boolean registerUser(Person user)
    {
        return users.add(user);
    }
    
    public void addFriendstoUser(Person user, Set<Person> friends)
    {
        if(friendshipRelations.containsKey(user))
        {
            var currentFriends = friendshipRelations.get(user);
            currentFriends.addAll(friends);
            friendshipRelations.put(user, currentFriends);
        }
        else
        {
            friendshipRelations.put(user, friends);
        }
    }

    public Set<Person> getUsers() {
        return new HashSet<>(users);
    }
    
    
    
    
}
