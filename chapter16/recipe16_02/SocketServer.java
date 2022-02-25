package org.java17recipes.chapter16.recipe16_02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class SocketServer {

    public static void main(String a[]) {
        final int httpd = 1234;
        ServerSocket ssock = null;
        try {
            ssock = new ServerSocket(httpd);
            System.out.println("have opened port 1234 locally");

            Socket sock = ssock.accept();
            System.out.println("client has made socket connection");

            communicateWithClient(sock);

            System.out.println("closing socket");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try{
                ssock.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public static void communicateWithClient(Socket socket) {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(
                    socket.getOutputStream(), true);


            String s = null;
            out.println("Server received communication!");
            while ((s = in.readLine()) != null) {
                System.out.println("received from client: " + s);
                out.flush();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
