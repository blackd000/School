
package Bai28;


import java.util.Scanner;

public class DiemMau extends Diem{
    private String mau;


    public DiemMau() {
        super();
        this.mau="";
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }
    public DiemMau(int x,int y,String mau) {
        this.setX(x);
        this.setY(y);
        this.mau = mau;
    }
    public void ganMau(String mau) {
        this.mau= mau;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhapDiem();
        System.out.print("Nhap mau:");
        mau= sc.nextLine();
    }
    public void hienThi() {
        super.hienThi();
        System.out.println("\nMau: "+mau);
    }


}
