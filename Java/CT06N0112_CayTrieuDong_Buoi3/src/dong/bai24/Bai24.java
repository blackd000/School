package dong.bai24;

/**
 * 24. Cài đặt lớp Diem2D (Điểm trong không gian 2 chiều) gồm:
 Thuộc tính: x, y là số nguyên.
 Các phương thức bao gồm :
 Phương thức khởi tạo mặc định: Diem();
 Phương thức khởi tạo có 2 tham số: Diem(int, int );
 Nhập tọa độ cho điểm từ bàn phím void nhapDiem ();
 Hiển thị ra màn hình tọa độ điểm theo dạng (x,y): void hienThi();
 Dời điểm đi 1 độ dời (dx, dy): void doiDiem(int dx, int dy);
 Lấy ra giá trị hoành độ của điểm: int giaTriX();
 Lấy ra giá trị tung độ của điểm: int giaiTriY();
 Tính khoảng cách từ điểm đó đến gốc tọa độ: float khoangCach();
 Tính khoảng cách từ điểm đó đến 1 điểm khác: float khoangCach(Diem d);
 * @author blackd000
 */
public class Bai24 {
	public static void main(String[] args) {
		Diem2D diem2D = new Diem2D(8, 9);

		System.out.println("khoang cach 1: " + diem2D.khoangCach());
		System.out.println("khoang cach 2: " + diem2D.khoangCach(new Diem2D(3, 4)));
	}
}
