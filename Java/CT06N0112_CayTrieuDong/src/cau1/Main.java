package cau1;

/**
 *
 * @author blackd000
 */
public class Main {
	
	public static void main(String[] args) {
		QuanLyPhongTro quanLyPhongTro = new QuanLyPhongTro();
		quanLyPhongTro.nhapDanhSach();
		System.out.println("Tong tien phong A: " + quanLyPhongTro.tongTienPhongA());
		System.out.println("Tong tien phong B: " + quanLyPhongTro.tongTienPhongB());
		System.out.println("Tong tien tat ca phong : " + quanLyPhongTro.tongTienTatCaPhong());
		System.out.println("So may tu 3 tro len: " + quanLyPhongTro.soMayPhongBTu3());
	}
}
