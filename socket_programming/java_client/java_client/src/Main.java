import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        Socket socket = new Socket("localhost", 1286);


        OutputStream socketOutput = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutput);
        socketDOS.writeUTF("Rasikhan");


        socketDOS.close();
        socketOutput.close();
        socket.close();
    }
}
