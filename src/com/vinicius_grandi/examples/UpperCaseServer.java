package com.vinicius_grandi.examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class UpperCaseServer {
    public static void main(String[] args) throws IOException {
        // it opens the connection
        ServerSocket socket = new ServerSocket(54321);

        var connection = socket.accept();

        // it gets the input stream from client
        DataInputStream input = new DataInputStream(connection.getInputStream());

        // it reads the message from client
        String lowerCaseMessage = input.readUTF();

        // client message is printed
        System.out.println(lowerCaseMessage);

        // create a new output stream and write send it as UTF to client
        DataOutputStream output = new DataOutputStream(connection.getOutputStream());
        output.writeUTF(lowerCaseMessage.toUpperCase());

        // closing all sockets and stream
        input.close();
        output.close();
        connection.close();
        socket.close();
    }
}
