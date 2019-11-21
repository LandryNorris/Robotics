package com.example.robotics;

public class Robot {
    private Network network;
    private int radius;
    private int theta;
    private boolean flag;

    // Getters & Setters
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getTheta() {
        return theta;
    }

    public void setTheta(int theta) {
        this.theta = theta;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    // Constructors
    public Robot() {
        network = new Network();
        network.initialize();
    }

    public Robot(String ip, int port) {
        network = new Network(ip, port);
        network.initialize();
    }

    // Close connection
    public void closeConnection() {
        if (network.getDs().isConnected()) {
            network.getDs().close();
        }
    }

    // Disconnect from socket
    public void disconnect() {
        if (network.getDs().isConnected()) {
            network.getDs().disconnect();
        }
    }

    // Not sure what values I need lol
    // Send move command (Joystick)
    public void sendMove(int radius, int theta) {
    }

    // Send command (Arm/Bucket commands)
    public void sendCommand(int button) {
        switch (button) {
            case 9:
                network.send(9);
                break;
            case 10:
                network.send(10);
                break;
            case 11:
                network.send(11);
                break;
            default:
                // Do nuttin lol
                break;
        }
    }
}