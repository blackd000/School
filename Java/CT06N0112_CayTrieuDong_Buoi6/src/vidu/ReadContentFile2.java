package vidu;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadContentFile2 {
    public static void main(String[] args) throws IOException{
        byte[] encode = Files.readAllBytes(Paths.get("file.txt"));
        String s = new String(encode, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
