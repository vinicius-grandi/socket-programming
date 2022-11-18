package com.vinicius_grandi.examples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class UpperCaseClient {
    public static void main(String[] args) throws IOException {
        // open the connection
        Socket socket = new Socket("localhost", 54321);

        // create a output stream and then gets the terminal message input
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // write the message through the socket
        output.writeUTF(line);

        // get the processed message from server and prints it
        DataInputStream input = new DataInputStream(socket.getInputStream());
        String upperCaseMessage = input.readUTF();
        System.out.println(upperCaseMessage);

        // close all sockets and streams
        input.close();
        output.close();
        socket.close();
    }
}
