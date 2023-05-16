
package Bai28;


public class Main {
    public static void main(String[] args) {
        DiemMau a = new DiemMau(5, 10, "White");
        System.out.println("Thong tin diem A: ");
        a.hienThi();
        DiemMau b= new DiemMau();
        b.nhap();
        b.doiDiem(10, 8);
        System.out.println("Thong tin diem B truoc khi doi: ");
        b.hienThi();
        b.setMau("Yellow");
        System.out.println("Thong tin diem B: ");
        b.hienThi();
    }
}