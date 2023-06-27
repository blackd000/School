package cau1;

/**
 *
 * @author blackd000
 */
public class PhongA extends Phong {

	private int nguoiThan;
	
	public PhongA(int maSoPhong, int soNguoiO, double soDien, double soNuoc, int nguoiThan) {
		super(maSoPhong, soNguoiO, soDien, soNuoc);
		this.nguoiThan = nguoiThan;
	}

	public int getNguoiThan() {
		return nguoiThan;
	}

	public void setNguoiThan(int nguoiThan) {
		this.nguoiThan = nguoiThan;
	}

	@Override
	public double tienPhong() {
		return 1400 + 2 * soDien + 8 * soNuoc + 50 * nguoiThan;
	}

	@Override
	public String toString() {
		return super.toString() + " nguoiThan=" + nguoiThan;
	}
}
