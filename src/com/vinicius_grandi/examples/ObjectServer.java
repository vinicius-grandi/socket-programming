package com.vinicius_grandi.examples;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        // input.readObject() reads the object sent
        Person person = (Person) input.readObject();

        System.out.println("Hello " + person.getFirstName() +  " " + person.getLastName());

        input.close();
        socket.close();
        serverSocket.close();
    }
}
