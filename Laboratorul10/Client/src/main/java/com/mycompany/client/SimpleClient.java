/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Radu
 */
public class SimpleClient {

    
    private static String getRefinedRequest(String request)
    {
        String solution = request.toLowerCase().strip().replaceAll(" +", " ");
        return solution;
    }
    
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        Scanner scanner = new Scanner(System.in);
        boolean isActive = true;
        String loggedUser = null;
        while(isActive)
        {
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            //send a request to the server
            
            String request = scanner.nextLine();
            
            request = getRefinedRequest(request);
            
            if(request.startsWith("friend") || request.startsWith("send") || request.startsWith("read") && loggedUser != null)
                request = request + " " + loggedUser;
            else if(request.startsWith("friend") || request.startsWith("send") || request.startsWith("read") && loggedUser == null)
            {
                System.out.println("You're not logged in!");
                break;
            }
                
            
            out.println(request);

            //wait a response from the server
            String response = in.readLine();
            String feedback = in.readLine();
            System.out.println(response);
            System.out.println(feedback);
            
            if(request.startsWith("login"))
                loggedUser = feedback;

        } catch (UnknownHostException ex) {
            System.err.println("No server listening..." + ex);
        }
        }

    }
}
