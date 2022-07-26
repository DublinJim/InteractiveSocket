package com.jamesMkeogh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("[SERVER] started....");
        Socket client = serverSocket.accept();
        System.out.println("[SERVER] connected....");

        BufferedReader incomingStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);

        while (true) {
            String incomingCommand = incomingStream.readLine();
            System.out.println(incomingCommand);
            if (Objects.equals(incomingCommand, "out")) {
                printWriter.println("quiting");
                break;
            }
            printWriter.println("received");
        }

        serverSocket.close();
        client.close();

    }
}
