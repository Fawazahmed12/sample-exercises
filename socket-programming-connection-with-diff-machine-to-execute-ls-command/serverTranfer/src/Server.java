import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server Started");
        ServerSocket serverSocket = new ServerSocket(11500);
        Socket socket = serverSocket.accept();
        System.out.println(socket);
        System.out.println("CLIENT CONNECTED");
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String command = (String) dataInputStream.readUTF();
        StringBuilder commandLineResult = new StringBuilder();
        String homeDirectory = System.getProperty("user.home");
        Process process = Runtime.getRuntime().exec(command, null, new File(homeDirectory));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                commandLineResult.append(line + "\n");
            }
        }
        dataOutputStream.writeUTF(commandLineResult.toString());
        serverSocket.close();
    }
}