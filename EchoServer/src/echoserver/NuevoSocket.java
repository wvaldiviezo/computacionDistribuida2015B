/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NuevoSocket implements Runnable {

    private  ServerSocket server;

    @Override
    public void run() {
        int portNumber = 9999;
        try {
            server = new ServerSocket(portNumber);

        } catch (IOException ex) {
            Logger.getLogger(NuevoSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  ServerSocket getServer() {
        return server;
    }

    public  void setServer(ServerSocket server) {
        this.server = server;
    }
    
    
}
