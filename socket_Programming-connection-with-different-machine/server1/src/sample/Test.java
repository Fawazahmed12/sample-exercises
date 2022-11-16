package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String args[]) throws IOException {
        String s;
//        Process p = Runtime.getRuntime().exec("ls");
        String homeDirectory = System.getProperty("user.home");
        Process p = Runtime.getRuntime().exec("ls",null, new File(homeDirectory));

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
    }
}
