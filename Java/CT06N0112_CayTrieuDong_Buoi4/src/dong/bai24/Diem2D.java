package dong.bai24;

import java.util.Scanner;

/**
 *
 * @author blackd000
 */
public class Diem2D {

	// fields
	private int x;
	private int y;

	// constructors
	public Diem2D() {

	}

	public Diem2D(int x, int y) {
		this.x = x;
		this.y = y;
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

	// business logic
	public void nhap() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Nhap x: ");
			x = input.nextInt();
			System.out.print("Nhap y: ");
			y = input.nextInt();
		}
	}

	public void hienThi() {
		System.out.println(this.getClass() + "(x,y)=" + "(" + x + "," + y + ")");
	}

	public void doiDiem(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public float khoangCach() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public float khoangCach(Diem2D d) {
		return (float) Math.sqrt((x - d.getX()) * (x - d.getX()) + (y - d.getY()) * (y - d.getY()));
	}

	@Override
	public String toString() {
		return "Diem2D{" + "x=" + x + ", y=" + y + '}';
	}
}
