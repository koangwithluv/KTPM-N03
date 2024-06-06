/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.SanPham;
import service.SanPhamService;
import service.SanPhamServiceImpl;
/**
 *
 * @author Acer-PC
 */
public class SanPhamController {
    private JButton jbtnSave;
    private JTextField jtfFullName;
    private JTextField jtfMaSanPham;
    private JTextField jtfDonGia;
    private JLabel jlbMessage;
    
    SanPham sanPham = null;
    SanPhamService sanPhamService = null;

    public SanPhamController(JButton jbtnSave, JTextField jtfFullName, JTextField jtfMaSanPham, JTextField jtfDonGia, JLabel jlbMessage) {
        this.jbtnSave = jbtnSave;
        this.jtfFullName = jtfFullName;
        this.jtfMaSanPham = jtfMaSanPham;
        this.jtfDonGia = jtfDonGia;
        this.jlbMessage = jlbMessage;
        
        sanPhamService = new SanPhamServiceImpl();
    }
    
    public void setView(SanPham sanPham){
        this.sanPham = sanPham;
        jtfFullName.setText(sanPham.getTenSanPham());
        jtfMaSanPham.setText(Integer.toString(sanPham.getMaSanPham()));
        jtfDonGia.setText(Double.toString(sanPham.getDonGia()));
        
        setEvent();
    }
    
    public void setEvent(){
    jbtnSave.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            try{
                if(!checkNotNull()){
                jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc");
            }else{
                sanPham.setTenSanPham(jtfFullName.getText());
                sanPham.setMaSanPham(Integer.parseInt(jtfMaSanPham.getText()));
                sanPham.setDonGia(Double.parseDouble(jtfDonGia.getText()));
                if(showDialog()){
                    int lastId = sanPhamService.creatOrUpdate(sanPham);
                    if(lastId != 0){
                        sanPham.setMaSanPham(lastId);
                        jtfMaSanPham.setText(Integer.toString(sanPham.getMaSanPham()));
                        jlbMessage.setText("Xử lí cập nhật thành công");
                        
                        
                    }else{
                        jlbMessage.setText("Error, Vui lòng thử lại");
                    }
                }
            }    
            } catch (Exception ex){
                            jlbMessage.setText(ex.toString());
                            System.out.println(e.toString());
                }
  
        }
        private boolean checkNotNull() {
        return jtfFullName.getText() != null && !jtfFullName.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

        @Override
        public void mouseEntered(MouseEvent e) {
            jbtnSave.setBackground(new Color(51, 204, 204));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            jbtnSave.setBackground(new Color(0,102,102));
        }
        
    });
    }
    
}
