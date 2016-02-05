/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoAnalizadorPass;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
 
public class EchoServer {
    public static void main(String[] args) throws IOException, InterruptedException {
       ArrayList<Thread> cs = new ArrayList<>(); 
        int portNumber = 9015;
        int i = 0;

        try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
            while(true){
                Socket s = serverSocket.accept();
                Thread c = new Thread(new ServerThread(s, "Thread:"+i));
                c.start();
                i++;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
    
}