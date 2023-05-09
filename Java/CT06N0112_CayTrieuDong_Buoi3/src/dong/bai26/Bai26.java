package dong.bai26;

/**
 * 26. Xây dựng lớp TamGiac (tam giác trong không gian oxy) có các thuộc tính và phương
thức như sau:
 Thuộc tính: 3 đỉnh là 3 điểm trong không gian oxy.
 Phương thức:
 Phương thức khởi tạo mặc định
 Phương thức khởi tạo có đầy đủ tham số
 Phương thức khởi tạo sao chép
 Các phương thức get/set
 Phương thức nhập
 Phương thức xuất
 Phương thức tính diện tích
 Phương thức tính chu vi
 Xây dựng lớp Main có phương thức main, suy nghĩ kịch bản sử dụng các phương thức
đã cài đặt của lớp TamGiac.
 * @author blackd000
 */
public class Bai26 {

	public static void main(String[] args) {
		TamGiac tg = new TamGiac(8, 9, 10);
		tg.xuat();

		System.out.println("Dien tich: " + tg.dienTich());
	}
}
