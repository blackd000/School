
package Bai29;

import java.util.Scanner;

public class NhanVien {
    Scanner scanner = new Scanner(System.in);
    private String maNhanVien,hoTen,diaChi;
    private int namVaoLam;
    protected int luong,lcb;

    public NhanVien(){
        super();
    }

    public NhanVien(String maNhanVien,String hoTen, String diaChi, int namVaoLam, int luong, int lcb) {
        super();
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.namVaoLam = namVaoLam;
        this.luong = luong;
        this.lcb = lcb;
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getNamVaoLam() {
        return namVaoLam;
    }

    public int getLuong() {
        return luong;
    }

    public int getLcb() {
        return lcb;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNamVaoLam(int namVaoLam) {
        this.namVaoLam = namVaoLam;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }


    public void setLcb(int lcb) {
        this.lcb = lcb;
    }
    public void nhap(){
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = scanner.nextLine();
        System.out.print("Nhập họ tên nhân viên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập Địa chỉ : ");
        diaChi = scanner.nextLine();
        System.out.print("Nhập năm vào làm: ");
        namVaoLam = scanner.nextInt();
        System.out.print("Nhập lương cơ bản: ");
        lcb = scanner.nextInt();
    }
    public int tinhLuong(){
        return 0;
    }

    @Override
    public String toString() {
        return "NhanVien{Ten = " + hoTen+ ", maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", namVaoLam=" + namVaoLam + ", lcb=" + lcb + '}';
    }

}
