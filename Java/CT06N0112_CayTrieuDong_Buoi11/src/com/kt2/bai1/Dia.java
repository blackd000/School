package com.kt2.bai1;

/**
 *
 * @author blackd000
 */
public class Dia extends SanPham {

	private int thoiGianPhut;

	public Dia() {
	}

	public Dia(SanPham sp, int thoiGianPhut) {
		this(sp.tuaDe, sp.soLuongBan, sp.giaBan);
		this.thoiGianPhut = thoiGianPhut;
	}

	private Dia(String tuaDe, int soLuongBan, double giaBan) {
		super(tuaDe, soLuongBan, giaBan);
	}

	public int getThoiGianPhut() {
		return thoiGianPhut;
	}

	public void setThoiGianPhut(int thoiGianPhut) {
		this.thoiGianPhut = thoiGianPhut;
	}

	@Override
	public String toString() {
		return super.toString() + ", thoiGianPhut=" + thoiGianPhut;
	}
}
