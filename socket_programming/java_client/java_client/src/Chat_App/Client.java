package Chat_App;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("localhost", 1234);
            System.out.println("You are connected to ARK's Machine");
            System.out.println("You can ask questions now!");

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("You :");

                String msgToServer = scanner.next();
                try {
                    bufferedWriter.write(msgToServer);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    System.out.println("Error sending msg to server... " + e);
                }

                try {
                    System.out.println("Server: " + bufferedReader.readLine());
                } catch (IOException e) {
                    System.out.println("Error receiving message from client... " + e);
                }

                if (msgToServer.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeEverything(socket, inputStreamReader, outputStreamWriter, bufferedWriter, bufferedReader);
        }
    }

    private static void closeEverything(Socket socket,
                                        InputStreamReader inputStreamReader,
                                        OutputStreamWriter outputStreamWriter,
                                        BufferedWriter bufferedWriter,
                                        BufferedReader bufferedReader) {
        try {
            if (socket != null) {
                socket.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
