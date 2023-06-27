package cau1;

/**
 *
 * @author blackd000
 */
public class PhongB extends Phong {

	private double giatui;
	private int somay;

	public PhongB(int maSoPhong, int soNguoiO, double soDien, double soNuoc,
		double giatui, int somay) {

		super(maSoPhong, soNguoiO, soDien, soNuoc);
		this.giatui = giatui;
		this.somay = somay;
	}

	public double getGiatui() {
		return giatui;
	}

	public void setGiatui(double giatui) {
		this.giatui = giatui;
	}

	public int getSomay() {
		return somay;
	}

	public void setSomay(int somay) {
		this.somay = somay;
	}

	@Override
	public double tienPhong() {
		return 2000 + 2 * soDien + 8 * soNuoc + giatui * 5 + somay * 100;
	}

	@Override
	public String toString() {
		return super.toString() + " giatui=" + giatui + ", somay=" + somay;
	}
}
