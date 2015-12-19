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
import java.util.ArrayList;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {
    	ArrayList<Integer> clientes = new ArrayList<Integer>();
    	EchoClient cliente= new EchoClient();
    	//Socket e=cliente.portNumber;
    	clientes.add(Integer.valueOf(cliente.portNumber));
    	 	    
       /*int portNumber = 9999;

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
        for (int i=0;i<clientes.size();i++){
        CorrerSocket t = new CorrerSocket(iniciar.getServer(), "thread "+i);
        t.start();
        try {
            t.join();
            
        } catch (Exception e) {
        
        }
        }
    }
}
