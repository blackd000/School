package dong.bai26;

import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class TamGiac {

	// fields
	private int x;
	private int y;
	private int z;

	// constructors
	public TamGiac() {

	}

	public TamGiac(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public TamGiac(TamGiac tg) {
		x = tg.getX();
		y = tg.getY();
		z = tg.getZ();
	}

	// getters, setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	// business logic
	public void nhap() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap x: ");
			x = input.nextInt();
			System.out.print("Nhap y: ");
			y = input.nextInt();
			System.out.print("Nhap z: ");
			z = input.nextInt();
		}
	}

	public void xuat() {
		System.out.println(this.getClass() + "[x=" + x + ", y=" + y + ", z=" + z + "]");
	}

	public double dienTich() {
		double p = (x + y + z) / 2.0;

		return Math.sqrt(p * (p - x) * (p - y) * (p - z));
	}

	public double chuVi() {
		return x + y + z;
	}
}
