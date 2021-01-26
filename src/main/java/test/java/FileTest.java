package test.java;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        File file = null;
        String text = "Hello world";
        BufferedWriter output = null;
        try {
            file = new File("example.txt");
            FileOutputStream is = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(text);
            w.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            //  file.delete();
        }

    }
}
