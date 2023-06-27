package cau1;

/**
 *
 * @author blackd000
 */
public abstract class Phong {
	
	protected int maSoPhong;
	protected int soNguoiO;
	protected double soDien;
	protected double soNuoc;

	public Phong(int maSoPhong, int soNguoiO, double soDien, double soNuoc) {
		this.maSoPhong = maSoPhong;
		this.soNguoiO = soNguoiO;
		this.soDien = soDien;
		this.soNuoc = soNuoc;
	}

	public abstract double tienPhong();

	@Override
	public String toString() {
		return "maSoPhong=" + maSoPhong + ", soNguoiO=" + soNguoiO + ", soDien=" + soDien + ", soNuoc=" + soNuoc;
	}
}
