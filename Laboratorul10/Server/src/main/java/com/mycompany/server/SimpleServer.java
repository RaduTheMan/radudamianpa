/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Radu
 */
public class SimpleServer {
    
    public static final int PORT = 8100;
    public static final int MAX_T = 4;
    
    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            boolean running = true;
            while(running)
            {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                //execute client request in a thread from the thread pool(TO DO)
//                new ClientThread(socket).start();
                ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
                
                pool.execute(new ClientThread(socket));
            }
            
        } catch (IOException ex) {
           System.err.println(ex);
        }
        finally{
            serverSocket.close();
        }
    }
    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
    }
}