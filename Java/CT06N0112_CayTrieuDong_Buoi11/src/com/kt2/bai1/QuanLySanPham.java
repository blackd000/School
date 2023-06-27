package com.kt2.bai1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blackd000
 */
public class QuanLySanPham {

	List<SanPham> cacSanPham;

	public QuanLySanPham() {
		cacSanPham = new ArrayList<>();
	}

	public void nhapSanPham() {
		while (true) {
			System.out.println("1 - Dia");
			System.out.println("2 - Sach");
			System.out.println("0 - Exit");
			int luaChon = Console.getInt("Ban chon cai nao: ");

			SanPham sp;
			switch (luaChon) {
				case 1:
					sp = nhapMotSp();
					int thoiGianPhut = Console.getInt("Nhap thoi gian: ");
					cacSanPham.add(new Dia(sp, thoiGianPhut));
					break;
				case 2:
					sp = nhapMotSp();
					int soLuongBan = Console.getInt("Nhap so luong ban: ");
					cacSanPham.add(new Sach(sp, soLuongBan));
					break;
				case 0:
					return;
				default:
					System.out.println("Khong co lua chon nay!!!");
			}
		}
	}

	private SanPham nhapMotSp() {
		String tuaDe = Console.getString("Nhap tua de: ");
		int soLuong = Console.getInt("Nhap so luong: ");
		double giaBan = Console.getDouble("Nhap gia ban: ");

		return new SanPham(tuaDe, soLuong, giaBan);
	}

	public double tongGiaBan() {

		double tong = 0;
		for (SanPham sp : cacSanPham) {
			tong += sp.soLuongBan * sp.giaBan;
		}
		return tong;
	}

	public void soTrang500() {
		for (SanPham sp : cacSanPham) {
			if (sp instanceof Sach) {
				Sach sach = (Sach) sp;
				if (sach.getSoTrang() > 500) {
					System.out.println(sach);
				}
			}
		}
	}

	public void phim60p() {
		for (SanPham sp : cacSanPham) {
			if (sp instanceof Dia) {
				Dia dia = (Dia) sp;
				if (dia.getThoiGianPhut() > 60) {
					System.out.println(dia);
				}
			}
		}
	}
}
