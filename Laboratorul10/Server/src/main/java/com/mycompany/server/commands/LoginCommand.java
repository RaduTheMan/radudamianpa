/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.commands;

import com.mycompany.server.commands.Command;
import com.mycompany.server.domain.Person;
import com.mycompany.server.domain.Person;
import com.mycompany.server.domain.SocialNetwork;
import com.mycompany.server.domain.SocialNetwork;

/**
 *
 * @author Radu
 */
public class LoginCommand extends Command {

    private SocialNetwork socialNetwork;
    
    public LoginCommand(SocialNetwork socialNetwork) {
        super("login", 1);
        this.socialNetwork = socialNetwork;
    }
    
    @Override
    public String execute() {
        Person person = new Person(parameters.get(0));
        if(socialNetwork.existsUser(person))
          return this.parameters.get(0);
        return null;
    }
    
}
