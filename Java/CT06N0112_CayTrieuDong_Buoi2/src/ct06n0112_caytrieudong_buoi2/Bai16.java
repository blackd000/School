/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ct06n0112_caytrieudong_buoi2;

import java.util.Scanner;

/**
 * Nhập số nguyên dương n. Đếm số lượng các chữ số lẻ của n.
 *
 * @author blackd000
 */
public class Bai16 {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap so nguyen duong di: ");
			int n = input.nextInt();

			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (i % 2 != 0) {
					count++;
				}
			}

			System.out.println("Co " + count + " so le");
		}
	}
}
