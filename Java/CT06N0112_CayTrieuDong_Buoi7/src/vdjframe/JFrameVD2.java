package vdjframe;

import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author blackd000
 */
public class JFrameVD2 extends JFrame{
    public JFrameVD2() throws HeadlessException {
        initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Vd tao cua so 2");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Container con = getContentPane();
        JButton btnThoat = new JButton("Thoat");
        btnThoat.setIcon(new ImageIcon("images/exit.jpg"));
        con.add(btnThoat);
    }
    
    public static void main(String[] args) {
        JFrameVD2 gui = new JFrameVD2();
        gui.setVisible(true);
    }
}
