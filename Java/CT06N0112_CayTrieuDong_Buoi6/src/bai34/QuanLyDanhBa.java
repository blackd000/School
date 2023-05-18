package bai34;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blackd000
 */
record DanhBa(String hoten, String sdt) implements Serializable {

}

public class QuanLyDanhBa {

	private static Scanner input = new Scanner(System.in);
	private static final Path filePath = Paths.get("src/bai34/danhSachDanhBa.ser");
	private static List<DanhBa> dsDanhBa = new ArrayList<>();

	public static void nhapDanhBa(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("Nhap ho ten: ");
			String hoten = input.nextLine();

			System.out.print("Nhap so dien thoai: ");
			String sdt = input.nextLine();

			dsDanhBa.add(new DanhBa(hoten, sdt));
		}
	}

	public static void xuatDanhBa() {
		System.out.println(dsDanhBa);
	}

	public static void serializeDanhBa() {
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (IOException ex) {
				Logger.getLogger(
					QuanLyDanhBa.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		try (ObjectOutputStream os = new ObjectOutputStream(
			new FileOutputStream(filePath.toFile()))) {
			os.writeObject(dsDanhBa);
		} catch (IOException ex) {
			Logger.getLogger(
				QuanLyDanhBa.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void deserializeDanhBa() {
		if (Files.exists(filePath)) {
			try (ObjectInputStream oi = new ObjectInputStream(
				new FileInputStream(filePath.toFile()))) {
				dsDanhBa = (List<DanhBa>) oi.readObject();
				System.out.println(dsDanhBa);
			} catch (IOException | ClassNotFoundException ex) {
				Logger.getLogger(
					QuanLyDanhBa.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String[] args) {
		int soLuongDanhBa;
		System.out.print("Muon nhap nhieu danh ba: ");
		soLuongDanhBa = input.nextInt();
		input.nextLine();

		nhapDanhBa(soLuongDanhBa);
		xuatDanhBa();

		serializeDanhBa();
		deserializeDanhBa();
	}
}
