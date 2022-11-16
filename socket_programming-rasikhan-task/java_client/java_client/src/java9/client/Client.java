package java9.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 1286);

        InputStream sIn = s.getInputStream();
        DataInputStream socketDIS = new DataInputStream(sIn);

        String testString = new String(socketDIS.readUTF());
        System.out.println(testString);

        socketDIS.close();
        sIn.close();
        s.close();
    }
}
