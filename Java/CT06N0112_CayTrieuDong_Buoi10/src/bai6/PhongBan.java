package bai6;

import java.util.Vector;

/**
 *
 * @author blackd000
 */
public class PhongBan {
    private String MaPhong;
    private String TenPhong;
    private Vector<NhanVien> DsNhanVien=new Vector<NhanVien>();

    public PhongBan(String MaPhong, String TenPhong, Vector<NhanVien> DsNhanVien) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.DsNhanVien = DsNhanVien;
    }

    public PhongBan() {
 
    }

    public PhongBan(String MaPhong, String TenPhong) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
    }

    /**
     * @return the MaPhong
     */
    public String getMaPhong() {
        return MaPhong;
    }

    /**
     * @param MaPhong the MaPhong to set
     */
    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    /**
     * @return the TenPhong
     */
    public String getTenPhong() {
        return TenPhong;
    }

    /**
     * @param TenPhong the TenPhong to set
     */
    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    /**
     * @return the DsNhanVien
     */
    public Vector<NhanVien> getDsNhanVien() {
        return DsNhanVien;
    }

    /**
     * @param DsNhanVien the DsNhanVien to set
     */
    public void setDsNhanVien(Vector<NhanVien> DsNhanVien) {
        this.DsNhanVien = DsNhanVien;
    }
    public void themNv(NhanVien nv){
        nv.setPhong(this);
        DsNhanVien.add(nv);
    }

    @Override
    public String toString() {
        return  TenPhong ;
    }
    
}
