package dong.bai25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 25. Cài đặt lớp PhanSo (Phân số) gồm:
 Các thuộc tính: tử số và mẫu số có kiểu số nguyên.
 Các hàm xây dựng gồm:
 Hàm khởi tạo mặc định:
 Hàm khởi tạo gồm 2 tham số:
 Các phương thức khác bao gồm:
 Hàm nhập giá trị cho 1 phân số. Nếu phân số vừa nhập có mẫu số = 0 thì yêu cầu nhập
lại.
 Hàm hiển thị phân số theo dạng tu/mau hoặc -tu/mau. Yêu cầu: nếu tử số =0 thì chỉ
in ra số 0, nếu mẫu số =1 thì chỉ in ra tử số.
 Hàm nghịch đảo phân số (làm thay đổi giá trị phân số) void nghichDao();
 Hàm tính ra phân số nghịch đảo của 1 phân số (phân số sẽ giữ nguyên nhưng hàm trả
về giá trị là phân số nghịch đảo của nó). PhanSo giaTriNghichDao();
 Hàm tính ra giá trị thực của phân số. Chẳng hạn phân số 1/2 có giá trị là 0.5.
 Hàm so sánh lớn hơn với phân số a. boolean lonHon(PhanSo a);
 Hàm cộng, trừ, nhân, chia phân số với 1 phân số a. Kết quả của hàm là 1 phân số.
 * @author blackd000
 */
public class SDPhanSo {
	public static void main(String[] args) {
		PhanSo psA = new PhanSo(3, 7);
		PhanSo psB = new PhanSo(4, 9);
		System.out.println(psA + "\n" + psB);

		PhanSo psX = new PhanSo();
		psX.nhap();
		PhanSo psY = new PhanSo();
		psY.nhap();

		psX.ngichDao();
		System.out.println(psX);

		PhanSo tongXY = psX.cong(psY);

		System.out.print("Nhap so luong phan so: ");
		int n = new Scanner(System.in).nextInt();

		PhanSo[] mangPhanSo = new PhanSo[n];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			mangPhanSo[i] = new PhanSo();
			mangPhanSo[i].nhap();
		}

		PhanSo tongPs = new PhanSo();
		for (PhanSo ps : mangPhanSo) {
			tongPs = tongPs.cong(ps);
		}

		PhanSo psLonNhat = new PhanSo(1, Integer.MAX_VALUE);
		for (PhanSo ps : mangPhanSo) {
			if (ps.lonHon(psLonNhat)) {
				psLonNhat.setTuSo(ps.getTuSo());
				psLonNhat.setMauSo(ps.getMauSo());
			}
		}

		Arrays.sort(mangPhanSo);
		System.out.println(Arrays.toString(mangPhanSo));
	}
}
