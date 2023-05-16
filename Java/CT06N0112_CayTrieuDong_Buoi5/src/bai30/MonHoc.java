package bai30;

import java.util.Scanner;

public abstract class MonHoc {
    String MaMonHoc ;
    String TenMonHoc;
    double diemTrungBinh=0;
    int SoTinChi;
    public MonHoc(){}

    public void Nhap() {
            Scanner input=new Scanner(System.in);
            System.out.println("Nhap ma mon hoc :");
            MaMonHoc=input.nextLine();
            System.out.println("Nhap ten mon hoc :");
            TenMonHoc=input.nextLine();
            System.out.println("Nhap so tin chi :");
            SoTinChi=input.nextInt();
    }

    public abstract double DTB();

    @Override
    public String toString() {
        return "MaMonHoc='" + MaMonHoc +  ", TenMonHoc='" + TenMonHoc + ", SoTinChi=" + SoTinChi ;
    }
}
