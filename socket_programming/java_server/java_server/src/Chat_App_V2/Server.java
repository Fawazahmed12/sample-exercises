package Chat_App_V2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

    public static void main(String[] args) throws IOException {
         Socket socket;
         BufferedReader bufferedReader;
         BufferedWriter bufferedWriter;
         ServerSocket serverSocket;

        HashMap<String, String> mfc = new HashMap<>();
        mfc.put("name?", "Rasikhan");
        mfc.put("age?", "25");
        mfc.put("education?", "B.E");
        mfc.put("place?", "Chennai");
        mfc.put("hi", "hi");

        Messagehandler message = new Messagehandler();
        message.setKey("name?");
        message.setValue("Rasikhan");

        Messagehandler message2 = new Messagehandler("age?", "25");

        serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        System.out.println("Waiting for a client....");

        try {
            socket = serverSocket.accept();

            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                try {
                    String msgFromClient = bufferedReader.readLine();
                    System.out.println("Client : " + msgFromClient);

                    if (msgFromClient.endsWith((String) message.getKey())) {
                        bufferedWriter.write("hi");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        break;
                    }

                } catch (IOException e) {
                    System.out.println("Error receiving message from client.." + e);
                }

            }
            closeEverything(socket, bufferedWriter, bufferedReader, serverSocket);
        } catch (IOException e) {
            System.out.println("Server creating Error" + e);
        }

    }

    private static void closeEverything(Socket socket,
                                        BufferedWriter bufferedWriter,
                                        BufferedReader bufferedReader,
                                        ServerSocket serverSocket) {
        try {
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
