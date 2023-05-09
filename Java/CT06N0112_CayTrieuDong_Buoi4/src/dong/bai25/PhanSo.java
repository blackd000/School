package dong.bai25;

import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class PhanSo implements Comparable<PhanSo> {

	// fields
	private int tuSo;
	private int mauSo;

	// constructors
	public PhanSo() {

	}

	public PhanSo(int tuSo, int mauSo) {
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}

	// getters, setters
	public int getTuSo() {
		return tuSo;
	}

	public void setTuSo(int tuSo) {
		this.tuSo = tuSo;
	}

	public int getMauSo() {
		return mauSo;
	}

	public void setMauSo(int mauSo) {
		this.mauSo = mauSo;
	}

	// business logic
	public void nhap() {
		Scanner input = new Scanner(System.in);

		System.out.print("Nhap tu so: ");
		tuSo = input.nextInt();

		int ms;
		do {
			System.out.print("Nhap mau so: ");
			ms = input.nextInt();

			if (ms < 0) {
				System.out.println("nhap lai!!");
			}
		} while (ms < 0);
		mauSo = ms;
	}

	public void hienThi() {
		if (tuSo == 0) {
			System.out.println(0);
		} else if (mauSo == 1) {
			System.out.println(1);
		} else {
			System.out.println(tuSo + "/" + mauSo);
		}
	}

	public void ngichDao() {
		if (tuSo == 0) {
			System.out.println("Ko dc");
			return;
		}

		int temp = tuSo;
		tuSo = mauSo;
		mauSo = temp;
	}

	public PhanSo giaTriNgichDao() {
		return new PhanSo(mauSo, tuSo);
	}

	public double giaTriThuc() {
		return tuSo / mauSo;
	}

	public boolean lonHon(PhanSo a) {
		if (tuSo / mauSo > a.getTuSo() / a.getMauSo()) {
			return true;
		}

		return false;
	}

	public PhanSo cong(PhanSo a) {
		int ts = tuSo * a.getMauSo() + mauSo * a.getMauSo();
		int ms = mauSo * a.getMauSo();
		return new PhanSo(ts, ms);
	}

	public PhanSo cong(int x) {
		return new PhanSo(tuSo + mauSo * x, mauSo);
	}

	public PhanSo tru(PhanSo a) {
		int ts = tuSo * a.getMauSo() - mauSo * a.getMauSo();
		int ms = mauSo * a.getMauSo();
		return new PhanSo(ts, ms);
	}

	public PhanSo tru(int x) {
		return new PhanSo(tuSo - mauSo * x, mauSo);
	}

	public PhanSo nhan(PhanSo a) {
		int ts = tuSo * a.getTuSo();
		int ms = mauSo * a.getMauSo();
		return new PhanSo(ts, ms);
	}

	public PhanSo nhan(int x) {
		return new PhanSo(tuSo * x, mauSo);
	}

	public PhanSo chia(PhanSo a) {
		int ts = tuSo * a.getMauSo();
		int ms = mauSo * a.getTuSo();
		return new PhanSo(ts, ms);
	}

	public PhanSo chia(int x) {
		return new PhanSo(tuSo, mauSo * x);
	}

	@Override
	public String toString() {
		return "PhanSo{" + "tuSo=" + tuSo + ", mauSo=" + mauSo + '}';
	}

	@Override
	public int compareTo(PhanSo o) {
		if (tuSo / mauSo > o.getTuSo() / o.getMauSo()) {
			return 1;
		} else if (tuSo / mauSo == o.getTuSo() / o.getMauSo()) {
			return 0;
		}
		return -1;
	}
}
