package java9.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1286);
        System.out.println("Waiting for a client....");

        Socket socket = ss.accept();
        System.out.println("Client accepted");

        OutputStream socketOutput = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutput);
        socketDOS.writeUTF("Hello Rasikhan");

        socketDOS.close();
        socketOutput.close();
        socket.close();
        ss.close();
    }
}
