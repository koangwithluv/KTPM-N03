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
import model.CongNhan;
import service.CongNhanService;
import service.CongNhanServiceImpl;

/**
 *
 * @author Acer-PC
 */
public class CongNhanController {
    private JButton jbtnSave;
    private JTextField jtfFullName;
    private JTextField jtfMaCongNhan;
    private JTextField jtfDiaChi;
    private JTextField jtfGioiTinh;
    private JTextField jtfEmail;
    private JTextField jtfSdt;
    private JLabel jlbMessage;
    
    private CongNhan congNhan = null;
    private CongNhanService congNhanService = null;

    public CongNhanController(JButton jbtnSave, JTextField jtfFullName, JTextField jtfMaCongNhan, JTextField jtfDiaChi, JTextField jtfGioiTinh,JTextField jtfEmail,JTextField jtfSdt, JLabel jlbMessage) {
        
        this.jbtnSave = jbtnSave;
        this.jtfFullName = jtfFullName;
        this.jtfMaCongNhan = jtfMaCongNhan;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfGioiTinh = jtfGioiTinh;
        this.jtfEmail = jtfEmail;
        this.jtfEmail = jtfEmail;
        this.jtfSdt = jtfSdt;
        this.jlbMessage = jlbMessage;
        
        this.congNhanService = new CongNhanServiceImpl();
    }
    public void setView(CongNhan congNhan){
        this.congNhan = congNhan;
            jtfFullName.setText(congNhan.getFullName());
            jtfMaCongNhan.setText(Integer.toString(congNhan.getMaCN()));
            jtfDiaChi.setText(congNhan.getDiaChi());
            jtfGioiTinh.setText(congNhan.getGioiTinh());
            jtfEmail.setText(congNhan.getEmail());
            jtfSdt.setText(congNhan.getSdt());
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
                congNhan.setFullName(jtfFullName.getText());
                congNhan.setGioiTinh(jtfGioiTinh.getText());
                congNhan.setDiaChi(jtfDiaChi.getText());
                congNhan.setMaCN(Integer.parseInt(jtfMaCongNhan.getText()));
                congNhan.setSdt(jtfSdt.getText());
                congNhan.setEmail(jtfEmail.getText());
                if(showDialog()){
                    int lastId = congNhanService.creatOrUpdate(congNhan);
                    if(lastId != 0){
                        congNhan.setMaCN(lastId);
                        jtfMaCongNhan.setText( Integer.toString(congNhan.getMaCN()));
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
