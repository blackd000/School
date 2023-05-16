
package Bai29;


public class NhanVienVanPhong extends NhanVien{
    private int soNgayLamViec, troCap;

    public NhanVienVanPhong() {
        super();
    }

    public NhanVienVanPhong(int soNgayLamViec, int troCap) {
        super();
        this.soNgayLamViec = soNgayLamViec;
        this.troCap = troCap;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public int getTroCap() {
        return troCap;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public void setTroCap(int troCap) {
        this.troCap = troCap;
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhập số ngày làm việc : "); this.soNgayLamViec= scanner.nextInt();
        System.out.println("Nhập trợ cấp : "); this.troCap=scanner.nextInt();
    }

    @Override
    public String toString() {
        return super.toString() + "\n, Số ngày làm việc : "+soNgayLamViec + ", Trợ Cấp : "+troCap + ", Lương : "+this.luong;
    }



    @Override
    public int tinhLuong() {
        this.luong = lcb+soNgayLamViec*100000 + troCap;
        return this.luong;
    }

}
