package com.vinicius_grandi.examples;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);

        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        Person person = new Person("John", "Wesley");

        // output.writeObject(val) writes a new object using socket
        output.writeObject(person);

        output.close();
        socket.close();
    }
}
