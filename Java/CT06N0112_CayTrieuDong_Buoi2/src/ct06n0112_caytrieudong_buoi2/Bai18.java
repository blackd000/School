/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ct06n0112_caytrieudong_buoi2;

import java.util.Scanner;

/**
 * Nhập 2 số nguyên dương m, n. Xuất ra hình chữ nhật đặc có kích thước mxn dấu *. 
 * Ví dụ: m = 4, n = 5.
	* * * * *
	* * * * *
	* * * * *
	* * * * *
 * @author blackd000
 */
public class Bai18 {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap hang: ");
			int m = input.nextInt();
			System.out.print("Nhap cot: ");
			int n = input.nextInt();

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
	}
}
