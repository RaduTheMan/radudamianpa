/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import com.mycompany.server.commands.CommandFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Radu
 */
public class ClientThread extends Thread {

    private Socket socket = null;
    private CommandFacade facade;

    public ClientThread(Socket socket, CommandFacade facade) {
        this.socket = socket;
        this.facade = facade;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            String raspuns = null;
            String feedback = null;
            var availableCommands = facade.getCommands();
            
            for(var command : availableCommands)
            {
                if(command.setParametersFromRequest(request))
                {
                    feedback = command.execute();
                    raspuns = "Command recognised: " + request + "\r\n" + feedback;
                    break;
                }
            }
            
            if(raspuns == null)
                raspuns = "Command error - invalid syntax or unrecognised command: " + request;  

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(raspuns);
            out.flush();
        } catch (IOException ex) {
            System.err.println("Communication error... " + ex);

        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
            
        }
    }

}
