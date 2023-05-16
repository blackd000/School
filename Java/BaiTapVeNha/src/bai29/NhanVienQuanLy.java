
package Bai29;

public class NhanVienQuanLy extends NhanVien{
    private int heSoChucVu,Thuong;

    public NhanVienQuanLy() {
        super();
    }

    public NhanVienQuanLy(int heSoChucVu, int Thuong) {
        super();
        this.heSoChucVu = heSoChucVu;
        this.Thuong = Thuong;
    }

    public int getHeSoChucVu() {
        return heSoChucVu;
    }

    public int getThuong() {
        return Thuong;
    }

    public void setHeSoChucVu(int heSoChucVu) {
        this.heSoChucVu = heSoChucVu;
    }





    public void setThuong(int Thuong) {
        this.Thuong = Thuong;
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhập hệ số chức vụ : "); this.heSoChucVu = scanner.nextInt();
        System.out.println("Nhâp thưởng : "); this.Thuong = scanner.nextInt();
    }
    @Override
    public int tinhLuong(){
        super.tinhLuong();
        this.luong = lcb*heSoChucVu + Thuong;
        return this.luong;
    }

    @Override
    public String toString() {
        return super.toString() +"\n Thưởng : "+Thuong + " , Hệ số chức vụ : "+heSoChucVu+" , Lương : "+ this.luong;
    }


}
