package baitap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MayTinh extends JFrame {

	private JPanel contentPane;
	private JPanel panel_main;

	private JButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_chia, btn_can, btn_nhan,
			btn_ptram, btn_tru, btn_nghich, btn_cong, btn_xoa, btn_bang, btn_daodau, btn_0;
	private JLabel lbl_hienthi;
	private long vl1,vl2;
	private String pheptoan="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MayTinh frame = new MayTinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void handleEvents() {
		btn_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_1.getText());
				lbl_hienthi.setText(String.valueOf(so));
			}
		});
		btn_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_2.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_3.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_4.getText());
				lbl_hienthi.setText(String.valueOf(so));
			}
		});
		btn_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_5.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_6.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_7.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_8.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_9.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String gt = lbl_hienthi.getText();
				if(gt.equals("0")) {
					gt="";
				}
				long so =Long.parseLong(gt+ btn_0.getText());
				lbl_hienthi.setText(String.valueOf(so));

			}
		});
		btn_cong.addActionListener(new ActionListener() {

			

			@Override
			public void actionPerformed(ActionEvent e) {
				 vl1 = Long.parseLong(lbl_hienthi.getText());
				 pheptoan="+";
				lbl_hienthi.setText("0");

			}
		});
		btn_tru.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				 pheptoan="-";
				lbl_hienthi.setText("0");

			}
		});
		btn_nhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				 pheptoan="*";
				lbl_hienthi.setText("0");
			}
		});
		btn_chia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				 pheptoan="/";
				lbl_hienthi.setText("0");

			}
		});
		btn_can.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				lbl_hienthi.setText(String.valueOf(Math.sqrt(vl1)));
				
			}
		});
		btn_ptram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				
				lbl_hienthi.setText(String.valueOf(vl1/100));

			}
		});
		btn_nghich.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				lbl_hienthi.setText(String.valueOf(1/vl1));

			}
		});
		btn_xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl_hienthi.setText("0");

			}
		});
		btn_daodau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl1 = Long.parseLong(lbl_hienthi.getText());
				lbl_hienthi.setText(String.valueOf(vl1*(-1)));

			}
		});
		btn_bang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vl2 = Long.parseLong(lbl_hienthi.getText());
				lbl_hienthi.setText("");
				if(pheptoan.equals("+")) {
					lbl_hienthi.setText(String.valueOf(vl1+vl2));
				}else if(pheptoan.equals("-")) {
					lbl_hienthi.setText(String.valueOf(vl1-vl2));
				}else if(pheptoan.equals("*")) {
					lbl_hienthi.setText(String.valueOf(vl1*vl2));
				}else if(pheptoan.equals("/")) {
					lbl_hienthi.setText(String.valueOf(vl1/vl2));
				}

			}
		});
	}

	public MayTinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("This is Caculator");
		setSize(400, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_screen = new JPanel();
		panel_screen.setBounds(5, 5, 376, 29);
		contentPane.add(panel_screen);
		panel_screen.setLayout(null);
		
		lbl_hienthi = new JLabel("0");
		lbl_hienthi.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_hienthi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_hienthi.setBounds(0, 0, 376, 29);
		panel_screen.add(lbl_hienthi);

		panel_main = new JPanel();
		panel_main.setBounds(5, 43, 376, 220);
		contentPane.add(panel_main);
		panel_main.setLayout(new GridLayout(4, 5, 3, 3));

		btn_1 = new JButton("1");
		btn_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_1);

		btn_2 = new JButton("2");
		btn_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_2);

		btn_3 = new JButton("3");
		btn_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_3);

		btn_chia = new JButton("/");
		btn_chia.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_chia);

		btn_can = new JButton("sqrt");
		btn_can.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_can);

		btn_4 = new JButton("4");
		btn_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_4);

		btn_5 = new JButton("5");
		btn_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_5);

		btn_6 = new JButton("6");
		btn_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_6);

		btn_nhan = new JButton("*");
		btn_nhan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_nhan);

		btn_ptram = new JButton("%");
		btn_ptram.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_ptram);

		btn_7 = new JButton("7");
		btn_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_7);

		btn_8 = new JButton("8");
		btn_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_8);

		btn_9 = new JButton("9");
		btn_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_9);

		btn_tru = new JButton("-");
		btn_tru.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_tru);

		btn_nghich = new JButton("1/x");
		btn_nghich.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_nghich);

		btn_0 = new JButton("0");
		btn_0.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_0);

		btn_daodau = new JButton("+/-");
		btn_daodau.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_daodau);

		btn_xoa = new JButton("C");
		btn_xoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_xoa);

		btn_cong = new JButton("+");
		btn_cong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_cong);

		btn_bang = new JButton("=");
		btn_bang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_main.add(btn_bang);
		handleEvents();
	}
}
