/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    private static void waitForConnection() throws IOException {
        System.out.println("Waiting for someone to connect \n");
        connection = server.accept();
        System.out.println("Connected to " + connection.getInetAddress().getHostName());
    }
    
    private static void sendMessage(String message) {
        try{
            output.writeObject("SERVER - " + message);
            output.flush();
            System.out.println("\n SERVER - " + message);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
}
