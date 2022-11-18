package com.vinicius_grandi.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedUppercaseServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);

        while (true) {
            Socket socket = serverSocket.accept();

            ThreadSockets thread = new ThreadSockets(socket);
            thread.start();
        }
    }
}
