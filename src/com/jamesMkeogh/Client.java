package com.jamesMkeogh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("[CLIENT] started....");
        Socket socket = new Socket("localhost",9090);
        System.out.println("[CLIENT] connected....");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        while (true) {
            System.out.println("> ");
            String command = keyboard.readLine();
            if (Objects.equals(command, "quit"))
                break;
            out.println(command);
            String response = bufferedReader.readLine();
            System.out.println("[SERVER] Response...."+response);
        }

        System.out.println("[SERVER] Closing....");
        socket.close();



    }

}
