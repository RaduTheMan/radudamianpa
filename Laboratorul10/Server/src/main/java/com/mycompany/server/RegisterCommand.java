/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

/**
 *
 * @author Radu
 */
public class RegisterCommand extends Command {

    private SocialNetwork socialNetwork;
    
    public RegisterCommand(SocialNetwork socialNetwork) {
        super("register", 1);
        this.socialNetwork = socialNetwork;
    }
    
    @Override
    public String execute() {
        if(this.parameters.size() == this.numberOfParameters)
        {
            Person user = new Person(this.parameters.get(0));
            boolean hasModified = socialNetwork.registerUser(user);
            if(hasModified)
                return "Registration completed successfully!";
            return "User already exists!";
        }
        return "Parameters not initialised!";
    }
    
}
