import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1286);
        System.out.println("Waiting for a client....");

        Socket socket = ss.accept();
        System.out.println("Client accepted");

        InputStream sIn = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(sIn);

        String testString = new String(socketDIS.readUTF());
        System.out.println("Welcome Mr."+ testString);

        socketDIS.close();
        sIn.close();
        socket.close();
        ss.close();
    }
}
