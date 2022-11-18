package com.vinicius_grandi.examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSockets extends Thread {
    final private Socket socket;

    public ThreadSockets(Socket s) {
        this.socket = s;
    }

    public void run() {
        System.out.println("New thread created!\n" + Thread.currentThread().getName());
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // read the message from client
            String lowerCaseMessage = input.readUTF();

            // client message is printed
            System.out.println(lowerCaseMessage);

            // create a new output stream and write send it as UTF to client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(lowerCaseMessage.toUpperCase());

            // close all sockets and streams
            input.close();
            output.close();
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Error" + ioe);
        }
    }
}
