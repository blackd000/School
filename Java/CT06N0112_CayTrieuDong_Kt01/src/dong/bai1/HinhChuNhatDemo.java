package dong.bai1;

/**
 *
 * @author blackd000
 */
public class HinhChuNhatDemo {
	public static void main(String[] args) {
		HinhChuNhat hcn1 = new HinhChuNhat(6, 4);
		System.out.println("Dien tich hcn1: " + hcn1.dienTich());
		System.out.println("Chu vi hcn1: " + hcn1.chuVi());

		HinhChuNhat hcn2 = new HinhChuNhat();
		hcn2.nhapDaiRong();
		System.out.println("Dien tich hcn2: " + hcn2.dienTich());
		System.out.println("Chu vi hcn2: " + hcn2.chuVi());
	}
}
