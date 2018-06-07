/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Entities.ProductTable;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author IPC
 */
public class NetworkHandlerService {

    //<editor-fold desc="SERVER SIDE METHODS" defaultstate="collapsed">
    private static ServerSocket server;
    private static HashMap<String, Socket> connections;
    private static HashMap<String, ObjectInputStream> inputs;
    private static HashMap<String, ObjectOutputStream> outputs;
    private static HashMap<String, Thread> connectionsThreads;
    private static int portNumber = 5000;
    
    // METHOD FOR INITIALIZING A SERVER
    public static void runAsServer() {
        connectionsThreads = new HashMap<>();
        inputs = new HashMap<>();
        outputs = new HashMap<>();
        connections = new HashMap<>();
        try {
            System.out.println("RUNNED AS SERVER");
            server = new ServerSocket(portNumber, 100);
            int connectionNumber = 1;
            while(true) {
                try {
                    System.out.println("waiting connection");
                    Socket connection = server.accept();
                    serverShowMessage("\nNow connected to " + connection.getInetAddress());
                    ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
                    connectionsThreads.put("Connection" + portNumber, newConnectionThread(connection, output, input, "Connection" + connectionNumber));
                    outputs.put("Connection" + connectionNumber, output);
                    inputs.put("Connection" + connectionNumber, input);
                    connections.put("Connection" + connectionNumber++, connection);
                    connection = null;
                } catch(EOFException eofException) {
                    serverShowMessage("\nServer Ended the Connection! ");
                } 
            }
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    // CREATING A THREAD FOR EVERY NEW CONNECTION
    private static Thread newConnectionThread(Socket connection, final ObjectOutputStream output, final ObjectInputStream input, String connectionName) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverShowMessage("\nStreams are now setted up!!");
                    String message = " You are now connected. . . . .";
                    serverSendMessage(message);
                    do {
                        try {
                            message = (String) input.readObject();
                            serverShowMessage("\n " + message);
                        } catch (ClassNotFoundException classNotFoundException) {
                            serverShowMessage(" Unkown Message sent by other network!");                
                        }
                    } while(!message.equals(" -CLIENT - END"));
                } catch (IOException ex) {
                    Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
                    closeServerConnections(connection, input, output, connectionName);
                }
            }
        });
        thread.start();
        return thread;
    }
    
    private static void serverShowMessage(final String text) {
        if(text.contains("reload")) {
            ProductTable.productsTableForm.reloadTable();
        } else {
            System.out.println("\nSERVER - " + text);
        }
    }
    
    // SEND MESSAGE OR SIGNAL TO CLIENTS
    public static void serverSendMessage(String message) {
        System.out.println(outputs.size() + "size outputs");
        outputs.forEach((key, output) -> {
            try {
                outputs.get(key).writeObject("SERVER - " + message);
                outputs.get(key).flush();
                System.out.println("sent to " + key);
            } catch (IOException ex) {
                Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        serverShowMessage("\n SERVER - " + message);   
    }
    
    private static void closeServerConnections(Socket connection, ObjectInputStream input, ObjectOutputStream output, String connectionName) {
        try {
            connections.get(connectionName).close();
            System.out.println("closed connection from " + connectionName);
            connections.remove(connectionName);
            inputs.get(connectionName).close();
            System.out.println("closed inputs from " + connectionName);
            inputs.remove(connectionName);
            outputs.get(connectionName).close();
            System.out.println("closed outputs from " + connectionName);
            outputs.remove(connectionName);
        } catch (IOException ex) {
            Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeAllServerConnections() {
        connections.forEach((key, connection) -> {
            try {
                connection.close();
            } catch (IOException ex) {
                Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
            }
            connections.remove(connection);
        });

        inputs.forEach((key, input) -> {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
            }
            inputs.remove(input);
        });

        outputs.forEach((key, output) -> {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
            }
            outputs.remove(output);
        });
        try {
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(NetworkHandlerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>
    
    //<editor-fold desc="CLIENT SIDE METHODS" defaultstate="collapsed">
    
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static String message = "";
    private static String serverIP = "";
    private static Socket connection;
    
    public static void runAsClient() {
        try {
            System.out.println("RUNNED AS client");
            connectToServer();
            setupStreams();
            whileChatting();
        } catch(EOFException eOFException) {
            serverShowMessage("\n Client terminated connection");
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }finally {
            closeCrap();
        }
    }
    
    private static void connectToServer() throws IOException {
        clientShowMessage("Attempting connection . . . . .\n");
        connection = new Socket(InetAddress.getByName(serverIP), portNumber++);
        clientShowMessage("Connected to " + connection.getInetAddress().getHostName());
        JOptionPane.showMessageDialog(null, InetAddress.getByName(serverIP).getHostName() + " | " + serverIP);
    }
    
    private static void setupStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        clientShowMessage("\n\n You are now connected . . . .");
    }
    
    private static void whileChatting() throws IOException {
        do {
            try {
                message = (String) input.readObject();
                clientShowMessage("\n" + message);
            } catch(ClassNotFoundException classNotFoundException) {
                clientShowMessage("\n Unknown object type to send");
            }
        } while(!message.equals("SERVER - END"));
    }
    
    private static void closeCrap() {
        clientShowMessage("\n Closing crap down");
        try {
            input.close();
            output.close();
            connection.close();
        } catch(IOException iOException) {
            iOException.printStackTrace();
        }
    }
    
    public static void clientSendMessage(String message) {
        try {
            output.writeObject("Client - " + message);
            clientShowMessage("Client - " + message);
        } catch(IOException iOException) {
            System.out.println("\n Something messed up!!");
        }
    } 
    
    private static void clientShowMessage(final String text) {
        if(text.contains("reload")) {
            ProductTable.productsTableForm.reloadTable();
        } else
            System.out.println("\nCLIENT - " + text);
    }    
    
    public static void closeConnection() {
        try {
            input.close();
            output.close();
            connection.close();
        } catch(IOException iOException) {
            iOException.printStackTrace();
        }
    }
    
    //</editor-fold>

    
}
