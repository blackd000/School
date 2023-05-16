
package Bai28;


import java.util.Scanner;

public class Diem {
    Scanner sc = new Scanner(System.in);
    private int x;
    private int y;

    public Diem() {
        this.x = 0;
        this.y = 0;
    }

    public Diem(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

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

    public void nhapDiem() {
        System.out.print("Nhap x:");
        x = sc.nextInt();
        System.out.print("Nhap y:");
        y = sc.nextInt();
    }

    public void hienThi() {
        System.out.print("(" + x +","+ y+")");

    }

    public void doiDiem(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
    public int giaTriX() {
        return x;
    }
    public int giaTriY() {
        return y;
    }
    public float khoangCach() {
        return (float) Math.sqrt(x*x+y*y);

    }
    public float khoangCach(Diem D) {
        return (float) Math.sqrt((x-D.x)*(x-D.x)+(y-D.y)*(y-D.y));
    }
}
