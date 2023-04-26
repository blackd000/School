/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.dong.src;

import java.time.YearMonth;
import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class BaiTapP1JavaCoBan {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
//		bai3();
//		bai4();
//		bai5();
//		bai6();
//		bai7();
//		bai8();
		bai9();
	}

	// Nhập vào 2 số nguyên, in ra màn hình số nhỏ hơn và số lớn hơn.
	public static void bai3() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap di (1): ");
			int num1 = input.nextInt();
			System.out.print("Nhap di (2): ");
			int num2 = input.nextInt();

			System.out.println(String.format(
				"Nho hon: %-5d, Lon hon %-5d",
				Math.min(num1, num2),
				Math.max(num1, num2)));
		} catch (Exception e) {
			System.out.println("Nhap so nguyen thoi!");
		}
	}

	// Nhập vào 3 số nguyên, in ra màn hình số nhỏ nhất và số lớn nhất.
	public static void bai4() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap di (1): ");
			int num1 = input.nextInt();
			System.out.print("Nhap di (2): ");
			int num2 = input.nextInt();
			System.out.print("Nhap di (3): ");
			int num3 = input.nextInt();

			int beNhat = Math.min(Math.min(num1, num2), num3);
			int lonNhat = Math.max(Math.max(num1, num2), num3);

			System.out.println(String.format(
				"Be nhat: %-5d, Lon nhat: %-5d",
				beNhat, lonNhat));
		} catch (Exception e) {
			System.out.println("Nhap so nguyen thoi!");
		}
	}

	// Giải và biện luận phương trình bậc 2 (ax2 + bx + c =0).
	public static void bai5() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap he so bac 2, a = ");
			float a = input.nextFloat();
			System.out.print("Nhap he so bac 1, b = ");
			float b = input.nextFloat();
			System.out.print("Nhap hang so, c = ");
			float c = input.nextFloat();

			// ax2 + bx + c = 0
			if (a == 0) {
				if (b == 0) {
					System.out.println("Vo nghiem");
				} else {
					System.out.println("Pt co 1 nghiem: "
						+ "x = " + (-c / b));
				}
				return;
			}

			float delta = b * b - 4 * a * c;
			float x1, x2;

			if (delta > 0) {
				x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
				x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
				System.out.println("Pt co 2 nghiem: "
					+ "x1 = " + x1 + " va x2 = " + x2);
			} else if (delta == 0) {
				x1 = (-b / (2 * a));
				System.out.println("Pt co nghiem kep: "
					+ "x1 == x2 = " + x1);
			} else {
				System.out.println("Pt vo nghiem");
			}
		} catch (Exception e) {
			System.out.print("Nhap float thoi!");
		}
	}

	// Nhập vào một số nguyên là năm, cho biết năm đó có là năm nhuần hay không. 
	// Biết rằng: năm nhuần là năm chia hết cho 400 hoặc chia hết cho 4 nhưng không 
	// chia hết cho 100.
	public static void bai6() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap nam (e.g: 2019): ");
			int year = input.nextInt();

			boolean isLeapYear = false;
			if ((year % 400 == 0 || year % 4 == 0) && (year % 100 != 0)) {
				isLeapYear = true;
			}

			if (isLeapYear) {
				System.out.println(year + " la nam nhuan");
			} else {
				System.out.println(year + " khong phai la nam nhuan");
			}
		}
	}

	// Nhập vào một số nguyên là tháng, cho biết tháng đó có bao nhiêu ngày 
	// (nếu là tháng 2 thì yêu cầu nhập thêm năm).
	public static void bai7() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap thang: ");
			int month = input.nextInt();

			if (month != 2) {
				YearMonth yearMonth = YearMonth.of(1999, month);
				System.out.println("So ngay: " + yearMonth.lengthOfMonth());
			} else {
				System.out.print("Nhap nam: ");
				int year = input.nextInt();

				YearMonth yearMonth = YearMonth.of(year, month);
				System.out.println("So ngay: " + yearMonth.lengthOfMonth());
			}
		}
	}

	// Nhập vào một số thực là điểm ở thang điểm 10, cho biết giá trị ở thang điểm chữ ABCDF
	// . Biết rằng: 8.5 => 10: A, 7.0 => 8.4: B, 5.5 => 6.9: C, 4.0 => 5.4: D, dưới 4: F.
	public static void bai8() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap diem: ");
			float score = input.nextFloat();

			if (score >= 8 && score <= 10) {
				System.out.println("A");
			} else if (score >= 7.0) {
				System.out.println("B");
			} else if (score >= 5.5) {
				System.out.println("C");
			} else if (score >= 4) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
		}
	}

	// Nhập vào chỉ số điện cũ và chỉ số điện mới. Tính tiền điện phải trả trong tháng, 
	// dữ liệu nhập phải đảm bảo chỉ số điện cũ <= chỉ số điện mới. Cách thức tính tiền 
	// điện theo quy định sau: 
	// 	 Bậc 1: cho các kWh từ 0 đến 50: 1480 VNĐ/kw; 
	// 	 Bậc 2: cho các kWh từ 51 đến 100: 1533 VNĐ/kw; 
	// 	 Bậc 3: cho các kWh từ 101 đến 200: 1786 VNĐ/kw; 
	// 	 Bậc 4: cho các kWh từ 201 đến 300: 2242 VNĐ/kw;  Bậc 5: cho các kWh từ 
	// 301 trở lên: 2503 VNĐ/kw;
	public static void bai9() {
		try (Scanner input = new Scanner(System.in)) {
			int soDienCu = 0, soDienMoi = 0;
			do {
				System.out.print("Nhap so dien cu: ");
				soDienCu = input.nextInt();
				System.out.print("Nhap so dien moi: ");
				soDienMoi = input.nextInt();

				if (soDienCu > soDienMoi) {
					System.out.print("Nhap lai!");
				}
			} while (soDienCu > soDienMoi);

			int soDien = soDienMoi - soDienCu;

			double soTienDien = 0;
			if (soDien >= 301) {
				soTienDien += (soDien - 300) * 2503;
				soDien = 300;
			}
			if (soDien >= 201) {
				soTienDien += (soDien - 200) * 2242;
				soDien = 200;
			}
			if (soDien >= 101) {
				soTienDien += (soDien - 100) * 1786;
				soDien = 100;
			}
			if (soDien >= 51) {
				soTienDien += (soDien - 51) * 1533;
				soDien = 51;
			}
			if (soDien >= 0) {
				soTienDien += soDien * 1480;
				soDien = 0;
			}

			System.out.println("So tien dien phai tra: " + soTienDien);
		}
	}
}
