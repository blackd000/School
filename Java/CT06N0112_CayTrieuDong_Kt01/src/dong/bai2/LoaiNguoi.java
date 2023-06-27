package dong.bai2;

import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public abstract class LoaiNguoi {

	// fiends
	protected String hoten;
	protected double luongCoBan;

	// constructors
	public LoaiNguoi() {

	}

	public LoaiNguoi(String hoten, double luongCoBan) {
		this.hoten = hoten;
		this.luongCoBan = luongCoBan;
	}

	@Override
	public String toString() {
		return "hoten=" + hoten + ", luongCoBan=" + luongCoBan + ", ";
	}
}
