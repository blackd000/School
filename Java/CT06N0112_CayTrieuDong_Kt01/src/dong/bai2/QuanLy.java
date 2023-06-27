package dong.bai2;

/**
 *
 * @author blackd000
 */
public class QuanLy extends LoaiNguoi {

	// fields
	private double capChucVu;

	// constructors
	public QuanLy() {

	}

	public QuanLy(String hoten, double luongCoBan, double capChucVu) {
		super(hoten, luongCoBan);
		this.capChucVu = capChucVu;
	}

	// getters, setters
	public double getChucVu() {
		return capChucVu;
	}

	public void setChucVu(double chucVu) {
		this.capChucVu = chucVu;
	}

	@Override
	public String toString() {
		return super.toString() + "chucVu=" + capChucVu;
	}
}
