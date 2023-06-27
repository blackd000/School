package com.kt2.bai1;

/**
 *
 * @author blackd000
 */
public class SanPham {

	protected String tuaDe;
	protected int soLuongBan;
	protected double giaBan;

	public SanPham() {
	}

	public SanPham(String tuaDe, int soLuongBan, double giaBan) {
		this.tuaDe = tuaDe;
		this.soLuongBan = soLuongBan;
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return "tuaDe=" + tuaDe + ", soLuongBan=" + soLuongBan + ", giaBan=" + giaBan;
	}
}
