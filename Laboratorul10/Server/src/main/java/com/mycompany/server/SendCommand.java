/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class SendCommand extends Command {

    private SocialNetwork socialNetwork;
    
    public SendCommand(SocialNetwork socialNetwork) {
        super("send", 2);
        this.socialNetwork = socialNetwork;
    }

    @Override
    public String execute() {
        Message message = new Message(this.parameters.get(0));
        Person user = new Person(this.parameters.get(1));
        var friends = socialNetwork.getFriendsFromUser(user);
        var messages = socialNetwork.getMessagesRef();
        for(var friend : friends)
        {
            if(messages.containsKey(friend))
            {
                var currentMessages = messages.get(friend);
                currentMessages.add(message);
                messages.put(friend, currentMessages);
            } 
            else
            {
                List<Message> listMessages = new ArrayList<>();
                listMessages.add(message);
                messages.put(friend, listMessages);
                
            }
        }
        return "Messages sent successfully";
    }
    
}
