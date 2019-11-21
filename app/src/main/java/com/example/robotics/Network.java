// Establish connection with robot
//Establish connection with robot
package com.example.robotics;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Network {
    private int port;
    private InetSocketAddress socketAddress;
    private DatagramPacket packet;
    private DatagramSocket ds;
    private byte[] buffer;

    // Getters & Setters
    public DatagramSocket getDs() {
        return ds;
    }

    public void setDs(DatagramSocket ds) {
        this.ds = ds;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    // Network Constructors
    Network() {
        setPort(80);
        socketAddress = new InetSocketAddress("192.168.4.1", port);
    }

    Network(String ip, int port) {
        socketAddress = new InetSocketAddress(ip, port);
    }

    // Initialize connection
    public void initialize() {
        try {
            connect();
            System.out.println("Connection ok \n");
        }
        catch (IOException i) {
            System.out.println("Connection not made");
        }
    }

    // Initialize connection (with specified ip and port)
    public void initialize(String ip, int port) {
        try {
            connect(ip, port);
            System.out.println("Connection ok \n");
        }
        catch (IOException i) {
            System.out.println("Connection not made");
        }
    }

    // Connect
    private void connect() throws SocketException {
        ds = new DatagramSocket();
        ds.connect(socketAddress);
    }

    private void connect(String ip, int port) throws SocketException {
        socketAddress = new InetSocketAddress(ip, port);
        ds = new DatagramSocket();
        ds.connect(socketAddress);
    }

    // Close connection
    public void close() {
        if (ds.isConnected()) {
            ds.close();
        }
    }

    // Send DatagramPacket
    public void send(int number) {
        buffer = convertIntToByteArray(number);

        if (ds.isConnected()) {
            packet = new DatagramPacket(buffer, buffer.length, socketAddress.getAddress(),
                    socketAddress.getPort());

            // Send packet
            try {
                ds.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Message sent \n");
            System.out.println(buffer[0]);
        }
    }

    // Disconnect socket
    public void disconnect() {
        if (ds.isConnected()) {
            ds.close();
            ds.disconnect();
        }
    }

    // Convert from int to ByteArray
    private byte[] convertIntToByteArray(int number) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(number).array();
    }

    private byte[] convertIntToByteArray(int number, int size) {
        return ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN).putInt(number).array();
    }
}
