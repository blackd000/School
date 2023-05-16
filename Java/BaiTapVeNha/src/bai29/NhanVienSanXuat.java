
package Bai29;

public class NhanVienSanXuat extends NhanVien{
    private int soSanPham;

    public NhanVienSanXuat() {
        super();
    }

    public NhanVienSanXuat(int soSanPham) {
        super();
        this.soSanPham = soSanPham;
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhập số sản phẩm : "); this.soSanPham= scanner.nextInt();
    }

    @Override
    public int tinhLuong() {
        this.luong = lcb + soSanPham*2000;
        return this.luong; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }



    @Override
    public String toString() {
        return super.toString() + "\n, Số sản phẩm : "+soSanPham+" , Lương : "+this.luong; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


}
