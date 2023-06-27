package com.kt2.bai1;

/**
 *
 * @author blackd000
 */
public class Sach extends SanPham {

	private int soTrang;

	public Sach() {
	}

	public Sach(SanPham sp, int soTrang) {
		this(sp.tuaDe, sp.soLuongBan, sp.giaBan);
		this.soTrang = soTrang;
	}

	private Sach(String tuaDe, int soLuongBan, double giaBan) {
		super(tuaDe, soLuongBan, giaBan);
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	@Override
	public String toString() {
		return super.toString() + ", soTrang=" + soTrang;
	}
}
