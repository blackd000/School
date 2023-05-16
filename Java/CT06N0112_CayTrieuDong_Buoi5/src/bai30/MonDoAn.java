package bai30;

import java.util.Scanner;

public class MonDoAn extends MonHoc{
    float diemGVHD;
    float diemGVPB;
    public MonDoAn(){}
    @Override
    public void Nhap() {
        Scanner input=new Scanner(System.in);
       super.Nhap();
        System.out.println("Nhap diem cua GVHD :");
        diemGVHD=input.nextFloat();
        System.out.println("Nhap diem cua GVPB :");
        diemGVPB=input.nextFloat();
    }

    @Override
    public double DTB() {
        diemTrungBinh=(diemGVHD+diemGVPB)/2;
        return diemTrungBinh;
    }

    @Override
    public String toString() {
        return super.toString()+ ", diemTrungBinh=" + diemTrungBinh ;

    }
}
