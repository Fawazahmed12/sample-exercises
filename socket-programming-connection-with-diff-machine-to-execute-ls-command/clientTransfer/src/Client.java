import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket clientSocket = new Socket("localhost", 10001);
        System.out.println("enter the command:");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

        dataOutputStream.writeUTF(command);
        System.out.println(dataInputStream.readUTF());
    }
}