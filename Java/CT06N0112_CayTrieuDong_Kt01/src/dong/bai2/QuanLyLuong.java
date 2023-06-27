package dong.bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class QuanLyLuong {

	private static Scanner input = new Scanner(System.in);
	private List<LoaiNguoi> dsnv = new ArrayList<>();

	// methods
	public void nhapNguoiLamViec() {
		while (true) {
			System.out.println("Nhap Nguoi Lam Viec");
			System.out.println("\t1: Nhap Nhan Vien");
			System.out.println("\t2: Nhap QuanLy");
			System.out.println("\t0: Thoat");
			System.out.print("Vui long lua chon: ");
			String line = input.nextLine();

			switch (line) {
				case "1":
					String hoten = "";
					double luongCoBan = 0;
					double tienTangCa = 0;

					boolean isError = true;
					while (isError) {
						try {
							System.out.print("Nhap ho ten: ");
							hoten = input.nextLine();

							System.out.print("Nhap luong co ban: ");
							luongCoBan = Double.parseDouble(input.nextLine());

							System.out.print("Nhap tien tang ca: ");
							tienTangCa = Double.parseDouble(input.nextLine());

							dsnv.add(new NhanVien(hoten, luongCoBan, tienTangCa));

							isError = false;
						} catch (NumberFormatException ex) {
							System.out.println("Ko nhap chu vao so");
						}
					}
					break;
				case "2":
					double capChucVu = 0;

					isError = true;
					while (isError) {
						try {
							System.out.print("Nhap ho ten: ");
							hoten = input.nextLine();

							System.out.print("Nhap luong co ban: ");
							luongCoBan = Double.parseDouble(input.nextLine());

							System.out.print("Nhap chuc vu: ");
							capChucVu = Double.parseDouble(input.nextLine());

							dsnv.add(new QuanLy(hoten, luongCoBan, capChucVu));

							isError = false;
						} catch (NumberFormatException ex) {
							System.out.println("Ko nhap chu vao so");
						}
					}
					break;
				case "0":
					return;
				default:
					System.out.println("Loi");
			}
		}
	}

	public void xuatNguoiLamViec() {
		System.out.println("");
		System.out.println(dsnv);
	}

	public static void main(String[] args) {
		QuanLyLuong qll = new QuanLyLuong();
		qll.nhapNguoiLamViec();
		qll.xuatNguoiLamViec();
	}

}
