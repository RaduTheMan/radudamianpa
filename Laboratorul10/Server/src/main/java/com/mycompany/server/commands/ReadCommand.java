/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.commands;

import com.mycompany.server.domain.Person;
import com.mycompany.server.domain.SocialNetwork;

/**
 *
 * @author Radu
 */
public class ReadCommand extends Command {

    private SocialNetwork socialNetwork;

    public ReadCommand(SocialNetwork socialNetwork) {
        super("read", 1);
        this.socialNetwork = socialNetwork;

    }

    @Override
    public String execute() {
        Person person = new Person(this.parameters.get(0));
        var messages = socialNetwork.getMessagesFromUser(person);
        return messages.toString();

    }

}
