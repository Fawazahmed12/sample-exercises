import java.io.*;
import java.net.*;

class MyClient1
{
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    public MyClient1()
    {
        try
        {
            //s=new Socket("10.10.0.3,10");
            s=new Socket("192.168.0.140",12000);
            System.out.println(s);
            din= new DataInputStream(s.getInputStream());
            dout= new DataOutputStream(s.getOutputStream());
            ClientChat();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void ClientChat() throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s1;
        do
        {
            s1=br.readLine();
            dout.writeUTF(s1);
            dout.flush();
            System.out.println("Server Message:"+din.readUTF());
        }
        while(!s1.equals("stop"));
    }
    public static void main(String as[])
    {
        new MyClient1();
    }
}
