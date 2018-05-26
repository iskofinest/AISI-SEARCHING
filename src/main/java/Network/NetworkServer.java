/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author IPC
 */
public class NetworkServer {

    private static ObjectInputStream input;
    private static ObjectOutputStream output;
    private static ServerSocket server;
    private static Socket connection;
    static PrintWriter out;
    static BufferedReader in;
    
    // WAIT AND ACCEPTS CONNECTION
    private static void waitForConnection() throws IOException {
        System.out.println("Waiting for someone to connect \n");
        connection = server.accept();
        out = new PrintWriter(connection.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.println("Connected to " + connection.getInetAddress().getHostName());
    }
    
    // SEND DATA
    private static void sendMessage(String message) {
        try{
            output.writeObject("SERVER - " + message);
            output.flush();
            System.out.println("\n SERVER - " + message);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    // WAIT TO RECEIVE THE DATA
    private void whileChatting() throws IOException{
        String message = "";
        System.out.println("You are now connected!");
//        ableToType(true);
        do{
            try{
                message = (String)input.readObject();
            } catch(ClassNotFoundException ex){
                System.out.println("\n Error Occured");
            }
        }while(!message.contains("END"));
    }
    
}
