package vidu;

import java.io.File;

public class ListFileInFolder {
    public static void main(String[] args) {
        File f = new File("file.txt");
        if (f.isDirectory()){
            File[] list = f.listFiles();
            for (File item:list) {
                System.out.println(item.getPath());
            }
        }
    }
}
