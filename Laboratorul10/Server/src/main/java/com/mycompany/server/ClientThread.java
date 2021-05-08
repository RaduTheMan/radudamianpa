/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

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

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Hello " + request + "!";
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
