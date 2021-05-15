/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Radu
 */
public class SocialNetwork {

    private Set<Person> users = new HashSet<>();
    private Map<Person, Set<Person>> friendshipRelations = new HashMap<>();
    private Map<Person, List<Message>> messages = new HashMap<>();
    private RestTemplate restTemplateObj = this.restTemplate();
    
    public RestTemplate restTemplate()
    {
        var factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }
    
    public boolean registerUser(Person user) {
        return users.add(user);
    }

    public Map<Person, List<Message>> getMessagesRef() {
        return this.messages;
    }

    public void addFriendstoUser(Person user, Set<Person> friends) {
        if (friendshipRelations.containsKey(user)) {
            var currentFriends = friendshipRelations.get(user);
            currentFriends.addAll(friends);
            friendshipRelations.put(user, currentFriends);
        } else {
            friendshipRelations.put(user, friends);
        }
    }

    public Set<Person> getFriendsFromUser(Person user) {
        return friendshipRelations.get(user);
    }

    public List<Message> getMessagesFromUser(Person user) {
        return messages.get(user);
    }
    
    public Set<Person> initialiseUsersFromDb()
    {
        final String uri = "http://localhost:8080/persons";
        String result = restTemplateObj.getForObject(uri, String.class);
        JSONArray array = new JSONArray(result);  
        for(int i=0;i<array.length();++i)
        {
            JSONObject object = array.getJSONObject(i);
            Person p = new Person(object.getString("name"));
            this.registerUser(p);
        }
        return new HashSet<>(users);
    }
    public Map<Person, Set<Person>> initialiseRelationsFromDb()
    {
        final String uri = "http://localhost:8080/relationships";
        String result = restTemplateObj.getForObject(uri, String.class);
        JSONArray array = new JSONArray(result);  
        for(int i=0;i<array.length();++i)
        {
            JSONObject object = array.getJSONObject(i);
            String name1 = object.getJSONObject("person1").getString("name");
            String name2 = object.getJSONObject("person2").getString("name");
            Person p1 = new Person(name1);
            Person p2 = new Person(name2);
            Set<Person> aux = new HashSet<>();
            aux.add(p2);
            this.addFriendstoUser(p1, new HashSet<>(aux));
            aux.remove(p2); aux.add(p1);
            this.addFriendstoUser(p2, new HashSet<>(aux));
            
        }
        return new HashMap<>(friendshipRelations);
    }

    public Set<Person> getUsers() {
        //testing get rest method
        final String uri = "http://localhost:8080/persons";
        return new HashSet<>(users);
    }

    public boolean existsUser(Person user) {
        return users.contains(user);
    }

    public Map<Person, Set<Person>> getFriendshipRelations() {
        return new HashMap<>(friendshipRelations);
    }

}
