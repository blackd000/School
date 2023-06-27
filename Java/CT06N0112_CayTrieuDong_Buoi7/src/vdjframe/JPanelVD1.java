package vdjframe;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author blackd000
 */
public class JPanelVD1 extends JFrame {

	public JPanelVD1() {
		init();
	}

	private void init() {
		this.setTitle("JPanel Demo");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.CYAN);
		JButton button1 = new JButton("Đây là nút lệnh");
		panel1.add(button1);
		con.add(panel1, BorderLayout.NORTH);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.PINK);
		JLabel lable1 = new JLabel("Đây là Lable");
		panel2.add(lable1);
		con.add(panel2, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JPanelVD1 p = new JPanelVD1();
		p.setVisible(true);
	}
}
