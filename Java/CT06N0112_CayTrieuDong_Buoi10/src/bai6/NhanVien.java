package bai6;

import java.util.Date;

/**
 *
 * @author blackd000
 */
public class NhanVien {
   private String MaSo;
   private String HoTen;
   private Date NgayLV;
   private Date NgaySinh;
   private PhongBan phong;

    public NhanVien(String MaSo, String HoTen, Date NgayLV, Date NgaySinh, PhongBan phong) {
        this.MaSo = MaSo;
        this.HoTen = HoTen;
        this.NgayLV = NgayLV;
        this.NgaySinh = NgaySinh;
        this.phong = phong;
    }

    public NhanVien() {
    }

    public String getMaSo() {
        return MaSo;
    }

    public String getHoTen() {
        return HoTen;
    }

    public Date getNgayLV() {
        return NgayLV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public PhongBan getPhong() {
        return phong;
    }

    public void setMaSo(String MaSo) {
        this.MaSo = MaSo;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setNgayLV(Date NgayLV) {
        this.NgayLV = NgayLV;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setPhong(PhongBan phong) {
        this.phong = phong;
    }

    public NhanVien(String MaSo, String HoTen, Date NgayLV, Date NgaySinh) {
        this.MaSo = MaSo;
        this.HoTen = HoTen;
        this.NgayLV = NgayLV;
        this.NgaySinh = NgaySinh;
    }

    @Override
    public String toString() {
        return  HoTen ;
    }
    
}
