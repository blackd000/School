package dong.vdoop;

public class GiaoVien {

	String hoTen;
	double HSluongGV;
	int soNgayNghi;

	public GiaoVien() {
		hoTen = "Nguyen Van A";
		HSluongGV = 2.34;
		soNgayNghi = 0;
	}

	public GiaoVien(String ten, double luong, int sn) {
		hoTen = ten;
		HSluongGV = luong;
		soNgayNghi = sn;
	}

	public double tinhLuong() {
		return HSluongGV * 1300;
	}

	public double giangDay() {
		return 0.0;
	}
}
