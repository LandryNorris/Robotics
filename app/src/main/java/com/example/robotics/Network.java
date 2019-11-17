// Establish connection with robot
//Establish connection with robot
package com.example.robotics;

import java.net.*;
import java.util.*;
import java.io.*;

class Network {
    private static final int PORT = 80;
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private InetAddress address;
    private PrintWriter command;
    private DatagramSocket socket_datagram;
    private DatagramPacket packet;

    // Default constructor
    public Network() {
        try {
            address = InetAddress.getByName("190.168.4.1");
            socket = new Socket(address, 80);
            socket_datagram = new DatagramSocket(PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Constructor to take ip and establish connection
    public Network(String address, int port) {
        // Establish connection
        try {
            this.address = InetAddress.getByName(address);
            socket = new Socket(this.address, port);
            socket_datagram = new DatagramSocket(PORT);
            System.out.println("Connected");

            // Establish connection
            establishConnection();
        }
        // Implement catch for UnknownHostException
        catch (UnknownHostException u) {
        }
        // Implement catch for IOException
        catch (IOException i) {
        }

    }

    // Establish connection method
    public void establishConnection() {

        try {
            // May need to change this too
            output = new DataOutputStream(socket.getOutputStream());

            // May need this? May get rid of it if output is all that
            // is needed
            command = new PrintWriter(socket.getOutputStream(), true);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Close connection
    public void closeConnection() {
        try {
            input.close();
            output.close();
            socket.close();
            socket_datagram.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    // Output bit
    public void outputCommand(String userInput, String joystickButton, String joystickAxis) {
        if (socket.isConnected())
        {

        }

        if (socket_datagram.isConnected())
        {

        }
    }
}