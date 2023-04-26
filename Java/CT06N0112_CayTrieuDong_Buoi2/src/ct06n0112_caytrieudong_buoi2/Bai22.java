package ct06n0112_caytrieudong_buoi2;

import java.util.Random;
import java.util.Scanner;

public class Bai22 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int select;
		int[] a;
		int n;
		System.out.println("Nhap so luong phan tu cua mang : ");
		n = input.nextInt();
		a = new int[n];

		while (true) {
			Menu();
			System.out.println("Nhap lua Chon : ");
			select = input.nextInt();
			switch (select) {
				case 0:
					return;
				case 1:
					NhapMang(a, n);
					break;
				case 2:
					RandomMang(a, n);
					break;
				case 3:
					XuatMang(a);
					break;
				case 4:
					GiaTriAm(a);
					break;
				case 5:
					System.out.println("Cac so nguyen to trong mang : ");
					LietKeSnt(a);
					break;
				case 6:
					int a1,
					 b;
					System.out.println("Nhap a : ");
					a1 = input.nextInt();
					System.out.println("Nhap b : ");
					b = input.nextInt();
					LietKeAtoB(a, a1, b);
					break;
				case 7:
					System.out.println("Tong cac So nguyn to la : " + TongSnt(a));
					break;
				case 8:
					System.out.println("Trung binh cong cac phan tu duong trong mang : " + TbCacPhanTuDuong(a));
					break;
				case 9:
					System.out.println("Nhap x : ");
					int x = input.nextInt();
					System.out.println("So phan tu lon hon x trong mang la : " + DemSoPhanTu(a, x));
					break;
				case 10:
					System.out.println("So phan tu co gia tri la so nguyen to trong mang la : " + DemSoNguyenTo(a));
					break;
				case 11:
					boolean check = KiemTraMangSoNguyenTo(a);
					if (check) {
						System.out.println("Mang chua toan bo so nguyen to");

					} else {
						System.out.println("Mang KHONG chua toan bo so nguyen to");
					}
					break;
				case 12:
					boolean checkMangtangDan = KiemTraMangTangDan(a);
					if (checkMangtangDan) {
						System.out.println("Mang nay la mang tang dan");

					} else {
						System.out.println("Mang KHONG phai la mang tang dan");
					}
					break;
				case 13:
					System.out.println("Gia tri lon nhan trong mang la :" + Max(a));
					break;
				case 14:
					System.out.println("Gia tri nho nhan trong mang la :" + Min(a));
					break;
				case 15:
					System.out.println("So am lon nhat rong mang la  :" + MaxAm(a));
					break;
				case 16:
					DaoNguocMang(a);
					break;
			}
		}
	}

	public static void DaoNguocMang(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[a.length - i];
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}

	public static float MaxAm(int[] a) {
		float maxAm = 0;
		int dem = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				dem++;
				maxAm = a[i];
				break;
			}
		}
		if (dem == 0) {
			return 0;
		}
		for (int j = 0; j < a.length; j++) {
			if ((a[j] < 0) && (maxAm < a[j])) {
				maxAm = a[j];
			}
		}
		return maxAm;
	}

	public static int Min(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	public static int Max(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public static boolean KiemTraMangTangDan(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean KiemTraMangSoNguyenTo(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (CheckSnt(a[i])) {
				count++;
			}
		}
		if (count == a.length) {
			return true;
		}
		return false;
	}

	public static int DemSoNguyenTo(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (CheckSnt(a[i])) {
				count++;
			}
		}
		return count;
	}

	public static int DemSoPhanTu(int[] a, int x) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (x < a[i]) {
				count++;
			}
		}
		return count;
	}

	public static float TbCacPhanTuDuong(int[] a) {
		int tong = 0;
		int dem = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				tong = tong + a[i];
				dem++;
			}
		}
		return tong / dem;
	}

	public static int TongSnt(int[] a) {
		int tong = 0;
		for (int i = 0; i < a.length; i++) {
			if (CheckSnt(a[i])) {
				tong = tong + a[i];
			}
		}
		return tong;
	}

	public static void NhapMang(int[] a, int n) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = input.nextInt();
			System.out.println();
		}
	}

	public static void RandomMang(int[] a, int n) {

		Random ran = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = ran.nextInt(398) - 199;
		}
	}

	public static void XuatMang(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		input.nextLine();
	}

	public static void GiaTriAm(int[] a) {
		System.out.println("Cac Gia Tri Am la : ");
		for (int i = 0; i < a.length; i++) {
			if (i < 0) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}

	public static void LietKeSnt(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (CheckSnt(a[i])) {
				System.out.print(a[i] + " ");
			}

		}
		System.out.println();
	}

	public static void LietKeAtoB(int[] a, int a1, int b) {
		for (int i = a1; i <= b; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean CheckSnt(int a) {
		if (a < 2) {
			return false;
		}
		if (a == 2) {
			return true;
		}
		for (int i = 3; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void Menu() {
		System.out.println("0.Thoat");
		System.out.println("1. Nhập giá trị cho n phần tử mảng từ bàn phím");
		System.out.println("2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng");
		System.out.println("3. Xuất mảng ra màn hình");
		System.out.println("4. Liệt kê các giá trị âm có trong mảng");
		System.out.println("5. Liệt kê các số nguyên tố có trong mảng");
		System.out.println("6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước");
		System.out.println("7. Tính tổng giá trị các phần tử là số nguyên tố");
		System.out.println("8. Tính trung bình cộng của các phần tử dương có trong mảng");
		System.out.println("9. Đếm số phần tử có giá trị lớn hơn x cho trước");
		System.out.println("10. Đếm số phần tử có giá trị là số nguyên tố trong mảng");
		System.out.println("11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố");
		System.out.println("12. Kiểm tra mảng có phải là mảng tăng dần");
		System.out.println("13. Tìm giá trị lớn nhất trong mảng");
		System.out.println("14. Tìm giá trị nhỏ nhất trong mảng");
		System.out.println("15. Tìm số âm lớn nhất trong mảng");
		System.out.println("16. Đảo ngược mảng");

	}
}
