/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ct06n0112_caytrieudong_buoi2;

import java.util.Scanner;

/**
 * Nhập vào ngày, tháng, năm. Cho biết ngày kế tiếp và ngày kế trước của ngày
 * đó.
 *
 * @author blackd000
 */
public class Bai11 {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int ngay, thang, nam;
			do {
				System.out.print("Nhap ngay: ");
				ngay = input.nextInt();
				System.out.print("Nhap thang: ");
				thang = input.nextInt();
				System.out.print("Nhap nam: ");
				nam = input.nextInt();

				if (!laNgayHopLe(ngay, thang, nam)) {
					System.out.println("Ko hop le");
				}
			} while (!laNgayHopLe(ngay, thang, nam));

			ngayHomTruoc(ngay, thang, nam);
			ngayHomSau(ngay, thang, nam);
		}
	}

	// after validate date
	public static void ngayHomTruoc(int ngay, int thang, int nam) {
		ngay--;
		if (ngay == 0) {
			thang--;
			if (thang == 0) {
				thang = 12;
				nam--;
			}

			ngay = tinhSoNgayTrongThang(thang, nam);
		}

		System.out.println("Ngay hom truoc:");
		System.out.println("Ngay: " + ngay + " "
			+ "Thang: " + thang + " "
			+ "Nam: " + nam);
	}

	// after validate date
	public static void ngayHomSau(int ngay, int thang, int nam) {
		ngay++;
		if (ngay > tinhSoNgayTrongThang(thang, nam)) {
			ngay = 1;
			thang++;
			if (thang > 12) {
				thang = 1;
				nam++;
			}
		}

		System.out.println("Ngay hom sau:");
		System.out.println("Ngay: " + ngay + " "
			+ "Thang: " + thang + " "
			+ "Nam: " + nam);
	}

	public static boolean laNgayHopLe(int ngay, int thang, int nam) {
		if (nam < 0) {
			return false;
		}

		if (thang < 1 || thang > 12) {
			return false;
		}

		if (ngay < 1 || ngay > tinhSoNgayTrongThang(thang, nam)) {
			return false;
		}

		return true;
	}

	public static int tinhSoNgayTrongThang(int thang, int nam) {
		switch (thang) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				return 31;
			}
			case 4, 6, 9, 11 -> {
				return 30;
			}
			case 2 -> {
				if (laNamNhuan(nam)) {
					return 29;
				} else {
					return 28;
				}
			}
		}

		return -1;
	}

	public static boolean laNamNhuan(int nam) {
		return ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0);
	}
}
