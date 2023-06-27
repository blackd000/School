package com.kt2.bai1;

import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);

	private Console() {
	}

	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine();

		return s;
	}

	public static int getInt(String prompt) {
		int i = 0;
		while (true) {
			System.out.print(prompt);
			try {
				i = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				// e.printStackTrace();
				System.out.println("So nguyen (int) khong hop le, vui long nhap lai!!");
			}
		}

		return i;
	}

	public static float getFloat(String prompt) {
		float f = 0;
		while (true) {
			System.out.print(prompt);
			try {
				f = Float.parseFloat(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("So thuc (float) khong hop le, vui long nhap lai!!");
			}
		}

		return f;
	}

	public static double getDouble(String prompt) {
		double d = 0;
		while (true) {
			System.out.print(prompt);
			try {
				d = Double.parseDouble(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("So thuc (double) khong hop le, vui long nhap lai!!");
			}
		}

		return d;
	}
}
