package vidu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadContentFile {
    public static void main(String[] args) throws IOException{
        List<String> list = Files.readAllLines(Paths.get("file.txt"), StandardCharsets.UTF_8);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
