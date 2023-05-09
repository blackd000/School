package dong.bai27;

import dong.bai24.Diem2D;
import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class DaGiac {

	// fields
	private int soCanh;
	private Diem2D arr[];
	private Scanner scanner = new Scanner(System.in);

	// constructors
	public DaGiac() {
	}

	public DaGiac(int soCanh, Diem2D[] arr) {
		this.soCanh = soCanh;
		this.arr = arr;
	}

	public DaGiac(DaGiac dg) {
		soCanh = dg.getSoCanh();
		arr = dg.getArr();
	}

	// getters, setters
	public int getSoCanh() {
		return soCanh;
	}

	public void setSoCanh(int soCanh) {
		this.soCanh = soCanh;
	}

	public Diem2D[] getArr() {
		return arr;
	}

	public void setArr(Diem2D[] arr) {
		this.arr = arr;
	}

	// business code
	public void nhap() {
		do {
			System.out.println("Nhap vao so canh!");
			soCanh = scanner.nextInt();

			if (soCanh <= 2) {
				System.out.println("Nhap lai");
			}
		} while (soCanh <= 2);

		arr = new Diem2D[soCanh];
		for (int i = 0; i < soCanh; i++) {
			System.out.println("Nhap canh thu: " + (i + 1) + " :");
			Diem2D diem = new Diem2D();
			diem.nhap();
			arr[i] = diem;
		}
	}

	public void xuat() {
		for (int i = 0; i < soCanh; i++) {
			System.out.print(arr[i]);
		}
	}

	public int tinhChuVi() {
		int cv = 0;
		for (int i = 0; i < soCanh - 1; i++) {
			cv += arr[i].khoangCach(arr[i + 1]);
		}
		return cv;
	}

	public Diem2D dinhXaNhat() {
		Diem2D dinh = arr[0];
		float xaNhat = arr[0].khoangCach();

		for (int i = 1; i < soCanh; i++) {
			float temp = arr[i].khoangCach();
			if (temp > xaNhat) {
				xaNhat = temp;
				dinh = arr[i];
			}
		}

		return dinh;
	}
}
