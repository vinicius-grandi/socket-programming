package com.vinicius_grandi.examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UpperCaseServer {
    public static void main(String[] args) throws IOException {
        // open the connection
        ServerSocket serverSocket = new ServerSocket(54321);

        // awaits for client connection and gets communication socket
        Socket socket = serverSocket.accept();

        // get the input stream from client
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
        serverSocket.close();
    }
}
