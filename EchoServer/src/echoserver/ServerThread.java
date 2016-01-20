/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{

    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;
    String id;
    
    public ServerThread(Socket socket, String thread) throws IOException {
        this.clientSocket = socket;
        this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        this.id = thread;
    }

    @Override
    public void run(){
        try {
            String inputLine;
            while ((inputLine = this.in.readLine()) != null) {
                this.out.println(inputLine);
                System.out.println(this.id);
                out.println("mesaje de "+id+"  "+inputLine);
                System.out.println("mensaje de "+id+" " + inputLine);
                
            }
        } catch (IOException ex) {
            System.out.println("Exception caught when trying to listen");
            System.out.println(ex);
        }
    }
}
