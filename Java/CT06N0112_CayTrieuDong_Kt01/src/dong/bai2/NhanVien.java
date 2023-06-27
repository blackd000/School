package dong.bai2;

/**
 *
 * @author blackd000
 */
public class NhanVien extends LoaiNguoi {

	// fields
	private double tienTangCa;

	// constructors
	public NhanVien() {

	}

	public NhanVien(String hoten, double luongCoBan, double tienTangCa) {
		super(hoten, luongCoBan);
		this.tienTangCa	= tienTangCa;
	}

	// getters, setters
	public double getTienTangCa() {
		return tienTangCa;
	}

	public void setTienTangCa(double tienTangCa) {
		this.tienTangCa = tienTangCa;
	}

	@Override
	public String toString() {
		return super.toString() + "tienTangCa=" + tienTangCa;
	}
}
