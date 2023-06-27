package vdjframe;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author blackd000
 */
public class JFrameVD1 extends JFrame{
    public JFrameVD1() {
        this.setTitle("Vd tao cua so 1");
        this.setSize(400, 300);
    }
    
    public JFrameVD1(String s){
        this.setTitle(s);
        this.setSize(300, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public static void main(String[] args) {
        JFrameVD1 frame2 = new JFrameVD1("Goi phuong thuc khoi tao 1 tham so");
        frame2.setVisible(true);
    }
}
