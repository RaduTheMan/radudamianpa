/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import com.mycompany.server.domain.SocialNetwork;
import com.mycompany.server.commands.CommandFacade;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Radu
 */
@SpringBootApplication
public class SimpleServer {

    public static final int PORT = 8100;
    public static final int MAX_T = 4;
    
    
    public static void main(String[] args) throws IOException  {
        SpringApplication.run(SimpleServer.class, args);
        SimpleServer server = new SimpleServer();
    }

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandFacade facade = new CommandFacade(socialNetwork);
        socialNetwork.initialiseUsersFromDb();
        socialNetwork.initialiseRelationsFromDb();

        try {
            serverSocket = new ServerSocket(PORT);
            boolean running = true;
            ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
            while (running) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();

                pool.execute(new ClientThread(socket, facade));
                System.out.println(socialNetwork.getUsers());
                System.out.println(socialNetwork.getFriendshipRelations());
                System.out.println(socialNetwork.getMessagesRef());
            }

        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            serverSocket.close();
        }
    }
    
    
}
