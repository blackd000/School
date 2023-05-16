
package Bai29;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên của công ty : "); int soNhanVIen= scanner.nextInt();
        NhanVien []nhanVien= new NhanVien[soNhanVIen];
        int []a= new int[soNhanVIen];
        int count= 0;
        System.out.println("Nhập thông tin cho nhân viên ");
        for(int i = 0;i<nhanVien.length;i++){
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.print("Chọn loại nhân viên (1 - Nhân viên quản lý , 2 - Nhân viên sản xuất , 3 - Nhân viên văn phòng): ");
            int choose = scanner.nextInt();

            if (choose == 1) {
                nhanVien[i] = new NhanVienQuanLy();
                a[count] = 1; count++;
            } else if (choose == 2) {
                nhanVien[i] = new NhanVienSanXuat();
                a[count] = 2; count++;
            }else if(choose ==3){
                nhanVien[i]= new NhanVienVanPhong();
                a[count] = 3; count++;
            }
            nhanVien[i].nhap();
            nhanVien[i].tinhLuong();
        }
        System.out.println("Thông tin của các nhân viên trong công ty: ");
        for (int i = 0; i < nhanVien.length; i++) {
            System.out.println(nhanVien[i].toString());
        }
        int tongLuong = 0;
        for (int i = 0; i < nhanVien.length; i++) {
            tongLuong += nhanVien[i].tinhLuong();
        }
        System.out.println("Tổng lương của công ty : "+tongLuong);
        int tongluong1=0;
        int tongluong2 = 0;
        int tongluong3 =0;
        for(int i = 0;i<a.length;i++){
            if(a[i]==1){
                tongluong1 +=nhanVien[i].tinhLuong();
            }else if(a[i]==2){
                tongluong2 +=nhanVien[i].tinhLuong();
            }else if(a[i]==3){
                tongluong3 +=nhanVien[i].tinhLuong();
            }
        }
        System.out.println("Tổng lương của nhân viên quản lý : "+tongluong1);
        System.out.println("Tổng lương của nhân viên sản xuất : "+tongluong2);
        System.out.println("Tổng lương của nhân viên văn phòng : "+tongluong3);

    }
}
