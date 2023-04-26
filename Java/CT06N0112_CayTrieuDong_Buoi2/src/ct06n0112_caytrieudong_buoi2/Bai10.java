/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ct06n0112_caytrieudong_buoi2;

import java.util.Scanner;

/**
 * Kiểm tra xem ngày (gồm 3 thành phần là ngày, tháng, năm) cho trước có phải là
 * một ngày hợp lệ. Trong đó, một ngày được gọi là hợp lệ khi:  Năm: số nguyên
 * lớn hơn 0;  Tháng: từ 1 đến 12;  Ngày từ 1 đến số ngày tối đa của tháng –
 * năm tương ứng.
 *
 * @author blackd000
 */
public class Bai10 {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap ngay: ");
			int ngay = input.nextInt();
			System.out.print("Nhap thang: ");
			int thang = input.nextInt();
			System.out.print("Nhap nam: ");
			int nam = input.nextInt();

			System.out.println("La ngay hop le: " + laNgayHopLe(ngay, thang, nam));
		}
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
