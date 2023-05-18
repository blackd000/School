package vidu;

import java.io.File;

public class GetFileInfo {

	public static void main(String[] args) {
		File f = new File("file.txt");

		if (f.isDirectory()) {
			System.out.println("Is folder");
		}
		if (f.isFile()) {
			System.out.println("Is File");
		}
		if (f.exists()) {
			System.out.println("File is exists");
		} else {
			System.out.println("File is not exists");
		}

		System.out.println("Absolute path: " + f.getAbsolutePath());
		System.out.println("Get path: " + f.getPath());
		System.out.println("Get name: " + f.getName());
		System.out.println("Get parent: " + f.getParent());
	}
}
