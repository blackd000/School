package dong.bai1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class HinhChuNhat {

	// fields
	private double chieuDai;
	private double chieuRong;
	private final Scanner input = new Scanner(System.in);

	// constructors
	public HinhChuNhat() {
		// default constructor
	}

	public HinhChuNhat(double chieuDai, double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	// getters, setters
	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	// methods
	public void nhapDaiRong() {
		boolean isError = true;
		while (isError) {
			try {
				System.out.print("Nhap chieu dai: ");
				chieuDai = Double.parseDouble(input.nextLine());

				System.out.print("Nhap chieu rong: ");
				chieuRong = Double.parseDouble(input.nextLine());

				isError = false;
			} catch (NumberFormatException ex) {
				System.out.println("Ko nhap chu vao so");
			}
		}
	}

	public double dienTich() {
		return chieuDai * chieuRong;
	}

	public double chuVi() {
		return (chieuDai + chieuRong) * 2;
	}
}
