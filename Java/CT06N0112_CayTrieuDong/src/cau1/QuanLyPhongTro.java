package cau1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blackd000
 */
public class QuanLyPhongTro {

	public List<Phong> danhSachPhong;

	public QuanLyPhongTro() {
		danhSachPhong = new ArrayList<Phong>();
	}

	public void nhapDanhSach() {
		while (true) {
			System.out.println("1 - Phong A");
			System.out.println("2 - Phong B");
			System.out.println("0 - Exit");
			int luaChon = Console.getInt("Ban chon cai nao: ");

			Phong phong;
			int maSoPhong;
			int soNguoiO;
			double soDien;
			double soNuoc;

			switch (luaChon) {
				case 1:
					maSoPhong = Console.getInt("Nhap ma so phong: ");
					soNguoiO = Console.getInt("Nhap so nguoi o: ");
					soDien = Console.getDouble("Nhap so dien: ");
					soNuoc = Console.getDouble("Nhap so nuoc: ");
					int nguoiThan = Console.getInt("Nhap nguoi than: ");
					danhSachPhong.add(new PhongA(maSoPhong, soNguoiO, soDien, soNuoc, nguoiThan));
					break;
				case 2:
					maSoPhong = Console.getInt("Nhap ma so phong: ");
					soNguoiO = Console.getInt("Nhap so nguoi o: ");
					soDien = Console.getDouble("Nhap so dien: ");
					soNuoc = Console.getDouble("Nhap so nuoc: ");
					double giatui = Console.getDouble("Nhap khoi luong giat ui: ");
					int somay = Console.getInt("Nhap so may: ");
					danhSachPhong.add(new PhongB(maSoPhong, soNguoiO, soDien, soNuoc, giatui, somay));
					break;
				case 0:
					return;
				default:
					System.out.println("Khong co lua chon nay!!!");
			}
		}
	}

	public double tongTienPhongA() {
		double tongTien = 0;
		for (Phong p : danhSachPhong) {
			if (p instanceof PhongA) {
				PhongA phongA = (PhongA) p;
				tongTien += phongA.tienPhong();
			}
		}
		return tongTien;
	}

	public double tongTienPhongB() {
		double tongTien = 0;
		for (Phong p : danhSachPhong) {
			if (p instanceof PhongB) {
				PhongB phongB = (PhongB) p;
				tongTien += phongB.tienPhong();
			}
		}
		return tongTien;
	}

	public double tongTienTatCaPhong() {
		double tongTien = 0;
		for (Phong p : danhSachPhong) {
			tongTien += p.tienPhong();
		}
		return tongTien;
	}

	public int soMayPhongBTu3() {
		int soMay = 0;
		for (Phong p : danhSachPhong) {
			if (p instanceof PhongB) {
				PhongB phongB = (PhongB) p;
				if (phongB.getSomay() >= 3) {
					soMay++;
				}
			}
		}
		return soMay;
	}
}
