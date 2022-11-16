package client;

import java.io.*;
import java.net.*;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    Client(String address, int port) throws IOException {

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);

            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }

        String line = "";
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                output.writeUTF(line);
                System.out.println(line);

            } catch (IOException e) {
                System.out.println(e);
            }
        }

        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.5", 5000);
    }
}
