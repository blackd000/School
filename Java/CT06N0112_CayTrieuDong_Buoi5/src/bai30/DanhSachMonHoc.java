package bai30;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class DanhSachMonHoc {
    List<MonDoAn> dsMonDoan ;
    List<MonLyThuyet> dsmonLyThuyet;
    List<MonThucHanh> dsmonThucHanh;
    int n;
    public DanhSachMonHoc(){
        dsMonDoan = new ArrayList<MonDoAn>();
        dsmonLyThuyet = new ArrayList<MonLyThuyet>();
        dsmonThucHanh = new ArrayList<MonThucHanh>();
    }
    public void NhapDánnhSach(){
        System.out.println("Nhap so luong mon hoc :");
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        for(int j=0;j<n;j++){
            System.out.println("Chon Mon hoc : (1.Mon do an, 2.Mon ly thuyet, 3.Mon thuc hanh :");
            int luaChon;
            luaChon=input.nextInt();
            switch (luaChon){
                case 1:{
                    System.out.println("Nhap thong tin mon hoc ");
                    MonDoAn mondoan=new MonDoAn();
                    mondoan.Nhap();
                    dsMonDoan.add(mondoan);
                    break;
                }
                case 2:{
                    System.out.println("Nhap thong tin mon hoc ");
                    MonLyThuyet monlythuyet=new MonLyThuyet();
                    monlythuyet.Nhap();
                    dsmonLyThuyet.add(monlythuyet);
                    break;
                }
                case 3:{
                    System.out.println("Nhap thong tin mon hoc :");
                    MonThucHanh monthuchanh=new MonThucHanh();
                    monthuchanh.Nhap();
                    dsmonThucHanh.add(monthuchanh);
                    break;
                }
                default:System.out.println("Lua chon khong dung !!!");
                        break;
            }

        }

    }
    public void xuatDanhSach(){
        System.out.println("-------------Danh Sach Mon Do AN----------------");
        for (int i=0;i<dsMonDoan.size();i++){
           System.out.println(dsMonDoan.get(i).toString());
        }
        System.out.println("-------------Danh Sach Mon Thuc Hanh----------------");
        for (int i=0;i<dsmonThucHanh.size();i++){
            System.out.println(dsmonThucHanh.get(i).toString());
        }
        System.out.println("-------------Danh Sach Mon Ly Thuyet---------------");
        for (int i=0;i<dsmonLyThuyet.size();i++){
            System.out.println(dsmonLyThuyet.get(i).toString());
        }
    }
}
