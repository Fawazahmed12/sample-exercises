package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Testprog {
    public static void main(String args[]) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ls");
            //pwd = presentWorkingDirectory, ls = folder, ls -l = details

            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            process.destroy();
        }
    }
}
