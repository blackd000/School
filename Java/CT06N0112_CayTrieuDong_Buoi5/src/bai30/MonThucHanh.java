package bai30;

import java.util.Arrays;
import java.util.Scanner;

public class MonThucHanh extends MonHoc{
    float diemKT[];
    public MonThucHanh(){
        diemKT= new float[4];
    }

    @Override
    public void Nhap() {
        Scanner input=new Scanner(System.in);
        super.Nhap();
        for(int i=0;i<4;i++){
            System.out.println("Nhap diem kiem tra thu "+(i+1)+" :");
            diemKT[i]=input.nextFloat();
        }
    }

    @Override
    public double DTB() {
        for(int i=0;i<4;i++){
            diemTrungBinh+=diemKT[i];
        }
        return diemTrungBinh/4;
    }

    @Override
    public String toString() {
        return super.toString() +", diemTrungBinh=" + diemTrungBinh ;

    }
}
