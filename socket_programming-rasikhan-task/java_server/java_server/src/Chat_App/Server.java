package Chat_App;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;
        Map<String,String> protocolMap = new HashMap<>();
        protocolMap.put("hi","HI");
        protocolMap.put("where","Chennai");
        protocolMap.put("name","ARK");
        protocolMap.put("age","25");
        protocolMap.put("education","B.E");

        serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        System.out.println("Waiting for a client....");

        try {
            socket = serverSocket.accept(); //blocking call

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            while (true) {
                String msgFromClient = bufferedReader.readLine();

                System.out.println("Client : " + msgFromClient);

                if(protocolMap.containsKey(msgFromClient)){
                    String reply = protocolMap.get(msgFromClient);
                    bufferedWriter.write(reply);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    continue;
                }

                if (msgFromClient.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            closeEverything(socket, inputStreamReader, outputStreamWriter,
                    bufferedWriter, bufferedReader, serverSocket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void closeEverything(Socket socket,
                                        InputStreamReader inputStreamReader,
                                        OutputStreamWriter outputStreamWriter,
                                        BufferedWriter bufferedWriter,
                                        BufferedReader bufferedReader,
                                        ServerSocket serverSocket) {
        try {
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
