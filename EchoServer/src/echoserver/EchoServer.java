/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author gato
 */
import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {

/*
        int portNumber = 9999;

        try (
               ServerSocket serverSocket =
                new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("devuelvo: "+inputLine);
                System.out.println("dato: " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
   }*/

        NuevoSocket iniciar = new NuevoSocket();
        iniciar.run();
        CorrerSocket t1 = new CorrerSocket(iniciar.getServer(), "thread 1");
        CorrerSocket t2 = new CorrerSocket(iniciar.getServer(), "thread 2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        
        }
    }
}
