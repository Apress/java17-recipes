package org.java17recipes.chapter16.recipe16_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

   public static Socket socket = null;
   public static PrintWriter out;
   public static BufferedReader in;

   public static void main(String[] args) {
       createConnection("127.0.0.1", 1234);
   }

   public static void createConnection(String host, int port) {

       try {
           //Create socket connection
           socket = new Socket(host, port);
           // Obtain a handle on the socket output
           out = new PrintWriter(socket.getOutputStream(),
                   true);
           // Obtain a handle on the socket input
           in = new BufferedReader(new InputStreamReader(
                   socket.getInputStream()));
           testConnection();
           System.out.println("Closing the connection...");
           out.close();
           in.close();
           socket.close();
           System.exit(1);
       } catch (UnknownHostException e) {
           System.out.println(e);
           System.exit(1);
       } catch (IOException e) {
           System.out.println(e);
           System.exit(1);
       }
   }

   public static void testConnection() {
       String serverResponse = null;
       if (socket != null && in != null && out != null) {
           System.out.println("Successfully connected, now testing...");

           try {
               // Send data to server
               out.println("Here is a test.");
               // Receive data from server
               while((serverResponse = in.readLine()) != null)
                   System.out.println(serverResponse);
           } catch (IOException e) {
               System.out.println(e);
               System.exit(1);
           }
       }
   }
}

