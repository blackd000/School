package bai6;

import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author blackd000
 */
public class QLNV_GUI extends JFrame{
    JComboBox<PhongBan> cboPb;
    JList<NhanVien> lstNv;
    JTextField txtMaNv,txtHoTen,txtNgayLv,txtNgaySinh;
    JButton btnThem ,btnLuu ,btnXoa, btnThoat;
    ArrayList<PhongBan> dsPhongBan;
    PhongBan pbSelected;
    NhanVien NvSelected;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    public QLNV_GUI(){
        init_Component();
        loadData();
        handleEvents();
    }
    private void handleEvents(){
        cboPb.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             pbSelected=(PhongBan)cboPb.getSelectedItem();
            lstNv.setListData(pbSelected.getDsNhanVien());
            lstNv.setSelectedIndex(0);
             NvSelected=lstNv.getSelectedValue();
            txtMaNv.setText(NvSelected.getMaSo());
            txtHoTen.setText(NvSelected.getHoTen());
            txtNgayLv.setText(sdf.format(NvSelected.getNgayLV()));
            txtNgaySinh.setText(sdf.format(NvSelected.getNgaySinh()));
            }
        
    });
        //click
        lstNv.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            NhanVien NvSelected=lstNv.getSelectedValue();
            txtMaNv.setText(NvSelected.getMaSo());
            txtHoTen.setText(NvSelected.getHoTen());
            txtNgayLv.setText(sdf.format(NvSelected.getNgayLV()));
            txtNgaySinh.setText(sdf.format(NvSelected.getNgaySinh()));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaNv.setText("");
                txtHoTen.setText("");
                txtNgayLv.setText("");
                txtNgaySinh.setText("");
                txtMaNv.requestFocus();
            }
        });
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    
                try {
                    NhanVien nv = new NhanVien(txtMaNv.getText(),txtHoTen.getText(),sdf.parse(txtNgayLv.getText()),sdf.parse(txtNgaySinh.getText()));
                    pbSelected.themNv(nv);
                    lstNv.setListData(pbSelected.getDsNhanVien());
                } catch (ParseException ex) {
                    
                }
               
                
            }
        
    });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(NvSelected!=null){
                    pbSelected.getDsNhanVien().remove(NvSelected);
                }
                NvSelected=null;
                lstNv.setListData(pbSelected.getDsNhanVien());
            }
        });
     btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
     });
    }
    
    private void loadData(){
        dsPhongBan=new ArrayList<PhongBan>();
        PhongBan pKt=new PhongBan("KT","Phòng kỹ thuật");
        dsPhongBan.add(pKt);
        //thêm nhân viên phong kỹ thuật
        NhanVien nv1=new NhanVien("Nv01","Nguyễn Lê A",new Date(2020-1900, 9 ,12 ),new Date(1990-1900, 8, 20));
        NhanVien nv2=new NhanVien("Nv02","Nguyễn văn B",new Date(2010-1900, 2 ,10 ),new Date(1990-1900, 6, 20));
        pKt.themNv(nv1);
        pKt.themNv(nv2);
        //
        PhongBan pKD=new PhongBan("KD","Phòng kinh doanh");
        NhanVien nv3=new NhanVien("Nv03","Nguyễn Lê C",new Date(2020-1900, 9 ,12 ),new Date(1990-1900, 8, 20));
        NhanVien nv4=new NhanVien("Nv04","Nguyễn văn D",new Date(2010-1900, 2 ,10 ),new Date(1990-1900, 6, 20));
        pKD.themNv(nv3);
        pKD.themNv(nv4);
        dsPhongBan.add(pKD);
        //gán data source 
        for (PhongBan pb : dsPhongBan){
            cboPb.addItem(pb);
        }
        lstNv.setListData(((PhongBan)cboPb.getSelectedItem()).getDsNhanVien());
        lstNv.setSelectedIndex(0);
        NvSelected=lstNv.getSelectedValue();
            txtMaNv.setText(NvSelected.getMaSo());
            txtHoTen.setText(NvSelected.getHoTen());
            txtNgayLv.setText(sdf.format(NvSelected.getNgayLV()));
            txtNgaySinh.setText(sdf.format(NvSelected.getNgaySinh()));
    }
    private void init_Component(){
        this.setTitle("Chương trình quản lý nhân viên");
        this.setSize(500,350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //
        Container con = getContentPane();
        BoxLayout boxLayout=new BoxLayout(con,BoxLayout.Y_AXIS);
        con.setLayout(boxLayout);
        //panel phòng ban
        JPanel pnPb=new JPanel();
        pnPb.setLayout(new FlowLayout());
        JLabel lbPb=new JLabel("Chọn Phòng Ban");
        cboPb=new JComboBox<>();
        cboPb.setPreferredSize(new Dimension(180,23));
        pnPb.add(lbPb);
        pnPb.add(cboPb);
        con.add(pnPb);
        
        //
        JPanel pnDsnv_CT=new JPanel();
        pnDsnv_CT.setLayout(new GridLayout(1,2));
        //panel dsnv (JList)
        JPanel PnDsnv= new JPanel();
        PnDsnv.setLayout(new BorderLayout());
        //tạo title border cho panel dsnv
        Border borderDsnv= BorderFactory.createLineBorder(Color.BLUE);
        TitledBorder titelDsnv = new TitledBorder(borderDsnv,"Danh sách nhân viên");
        PnDsnv.setBorder(titelDsnv);
        //Jlist Dsnv
        lstNv=new JList<>();
        JScrollPane spDsnv=new JScrollPane(lstNv,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        PnDsnv.add(spDsnv);
        pnDsnv_CT.add(PnDsnv);
        con.add(pnDsnv_CT);
        
        
         //Panel chứa tt chi tiết
        JPanel pnCtNv=new JPanel();
        pnCtNv.setLayout(new BoxLayout(pnCtNv,BoxLayout.Y_AXIS));
        pnDsnv_CT.add(pnCtNv);
        Border borderCTNv=BorderFactory.createLineBorder(Color.BLUE);
        TitledBorder tittleCtNv=new TitledBorder(borderCTNv,"Thông tin chi tiết");
        pnCtNv.setBorder(tittleCtNv);
        
        //panel chưa tt mã số
        JPanel pnMaSo=new JPanel();
        pnMaSo.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbMaSo=new JLabel("Mã số");
        txtMaNv=new JTextField(13);
        pnMaSo.add(lbMaSo);
        pnMaSo.add(txtMaNv);
        pnCtNv.add(pnMaSo);
        
        //panel chưa tt Họ tên
        JPanel pnHoTen=new JPanel();
        pnHoTen.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbHoTen=new JLabel("Họ và tên");
        txtHoTen=new JTextField(13);
        pnHoTen.add(lbHoTen);
        pnHoTen.add(txtHoTen);
        pnCtNv.add(pnHoTen);
        
        //panel chưa tt Ngày Sinh
        JPanel pnNgaySinh=new JPanel();
        pnNgaySinh.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbNgaySinh=new JLabel("Ngày sinh");
        txtNgaySinh=new JTextField(13);
        pnNgaySinh.add(lbNgaySinh);
        pnNgaySinh.add(txtNgaySinh);
        pnCtNv.add(pnNgaySinh);
        //panel chưa tt Ngày Vào làm
        JPanel pnNgayVl=new JPanel();
        pnNgayVl.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbNgayVl=new JLabel("Ngày làm việc");
        txtNgayLv=new JTextField(13);
        pnNgayVl.add(lbNgayVl);
        pnNgayVl.add(txtNgayLv);
        pnCtNv.add(pnNgayVl);
        
        //set kích thước có Label
        lbMaSo.setPreferredSize(lbNgayVl.getPreferredSize());
        lbHoTen.setPreferredSize(lbNgayVl.getPreferredSize());
        lbNgaySinh.setPreferredSize(lbNgayVl.getPreferredSize());
        
        
       //Tạo panel chưa các nút lệnh
       JPanel PnNutLenh=new JPanel();
       PnNutLenh.setLayout(new FlowLayout(FlowLayout.RIGHT));
       con.add(PnNutLenh);
       btnLuu=new JButton("Lưu");
       btnThem=new JButton("Thêm");
       btnThoat=new JButton("Thoát");
       btnXoa=new JButton("Xóa");
       PnNutLenh.add(btnThem);
       PnNutLenh.add(btnLuu);
       PnNutLenh.add(btnXoa);
       PnNutLenh.add(btnThoat);
    }
    
    
    public static void main(String[] args) {
        new QLNV_GUI().setVisible(true);
    }
}
