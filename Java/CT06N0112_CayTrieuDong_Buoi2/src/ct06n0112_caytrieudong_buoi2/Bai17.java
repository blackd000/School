/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ct06n0112_caytrieudong_buoi2;

import java.util.Scanner;

/**
 * Nhập số nguyên dương n. Tính tổng số lượng các chữ số chẵn của n.
 *
 * @author blackd000
 */
public class Bai17 {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap so nguyen duong di: ");
			int n = input.nextInt();

			int tongSoChan = 0;
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					tongSoChan += i;
				}
			}

			System.out.println("Tong so chan la: " + tongSoChan);
		}
	}
}
