/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.SwingUtilities;


/**
 *
 * @author IPC
 */
public class Server {
    
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ServerSocket server;
    private Socket connection;
    
    
    public void startRunning() {
        try {
            server = new ServerSocket(6789, 100);
            while(true) {
                try {
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                } catch(EOFException eOFException) {
                    eOFException.printStackTrace();
                } finally {
                    closeConnection();
                }
            }
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    //wait for connection, then display the connection information
    private void waitForConnection() throws IOException {
        System.out.println("Waiting for someone to connect \n");
        connection = server.accept();
        System.out.println("Connected to " + connection.getInetAddress().getHostName());
    }
    
    // get stream to send and receive data
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        System.out.println("\n\nStreams are not setup!!!!\n\n");
    }
    
    // during the conversation
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
    
    // close stream 
    private void closeConnection(){
        System.out.println("\n Closing Connections");
//        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    private void sendMessage(String message) {
        try{
            output.writeObject("SERVER - " + message);
            output.flush();
            System.out.println("\n SERVER - " + message);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    private void showMessage(final String message) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        System.out.println("THE MESSAGE: " + message);
                    }
                }
        );
    }
    
}
