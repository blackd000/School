package bai33;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blackd000
 */
record KhachHang(int maso, String hoten, LocalDate namsinh) {

}

public class QuanLyKhachHang {

	private static Scanner input = new Scanner(System.in);
	private static final Path filePath = Paths.get("src/bai33/danhSachKhachHang.txt");
	private static List<KhachHang> dsKhachHang = new ArrayList<>();

	public static void nhapKhachHang(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("Nhap ma so: ");
			int maso = input.nextInt();
			input.nextLine();

			System.out.print("Nhap ho ten: ");
			String hoten = input.nextLine();

			System.out.print("Nhap nam sinh: ");
			LocalDate namsinh = LocalDate.parse(input.next());

			dsKhachHang.add(new KhachHang(maso, hoten, namsinh));
		}
	}

	public static void xuatKhachHang() {
		System.out.println(dsKhachHang);
	}

	public static void ghiKhachHang() {

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (IOException ex) {
				Logger.getLogger(
					QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		try (PrintWriter out = new PrintWriter(new BufferedWriter(
			new FileWriter(filePath.toFile())))) {

			for (KhachHang kh : dsKhachHang) {
				out.println(kh);
			}
		} catch (IOException ex) {
			Logger.getLogger(
				QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void docKhachHang() {
		if (Files.exists(filePath)) {
			try (BufferedReader in = new BufferedReader(new FileReader(filePath.toFile()))) {
				String line;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException ex) {
				Logger.getLogger(
					QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String[] args) {
		int soLuongKhachHang;
		System.out.print("Muon nhap nhieu khach hang: ");
		soLuongKhachHang = input.nextInt();

		nhapKhachHang(soLuongKhachHang);
		xuatKhachHang();

		ghiKhachHang();
		docKhachHang();
	}
}
