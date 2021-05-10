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
public class CommandFacade {
    List<Command> commands = new ArrayList<>();
    
    public CommandFacade(SocialNetwork socialNetwork)
    {
        commands.add(new RegisterCommand(socialNetwork));
        commands.add(new LoginCommand());
        commands.add(new FriendCommand(socialNetwork));
        commands.add(new SendCommand());
        commands.add(new ReadCommand());
    }

    public List<Command> getCommands() {
        return new ArrayList<>(commands);
    }
    
    
}
