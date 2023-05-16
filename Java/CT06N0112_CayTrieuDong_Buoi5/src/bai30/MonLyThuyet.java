package bai30;

import java.util.Scanner;

public class MonLyThuyet extends MonHoc {
    float diemTuLuan;
    float diemCuoiKi;
    float DiemGiuaKi;
    public MonLyThuyet(){}

    @Override
    public void Nhap(){
        Scanner input=new Scanner(System.in);
        super.Nhap();
        System.out.println("Nhap diem tu luan :");
        diemTuLuan=input.nextFloat();
        System.out.println("Nhap diem giua ki:");
        DiemGiuaKi=input.nextFloat();
        System.out.println("Nhap diem cuoi ki:");
        diemCuoiKi=input.nextFloat();
    }
    @Override
    public double DTB() {
        diemTrungBinh=diemTuLuan*0.2+0.3*DiemGiuaKi+0.5*diemCuoiKi;
        return diemTrungBinh;
    }

    @Override
    public String toString() {
        return super.toString()+  ", diemTrungBinh=" + diemTrungBinh;
    }
}
