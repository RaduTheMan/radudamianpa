/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.commands;

import com.mycompany.server.domain.SocialNetwork;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class CommandFacade {

    List<Command> commands = new ArrayList<>();

    public CommandFacade(SocialNetwork socialNetwork) {
        commands.add(new RegisterCommand(socialNetwork));
        commands.add(new LoginCommand(socialNetwork));
        commands.add(new FriendCommand(socialNetwork));
        commands.add(new SendCommand(socialNetwork));
        commands.add(new ReadCommand(socialNetwork));
    }

    public List<Command> getCommands() {
        return new ArrayList<>(commands);
    }

}
