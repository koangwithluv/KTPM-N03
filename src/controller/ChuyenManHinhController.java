/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.CongJPanel;
import view.CongNhanJPanel;
import view.SanPhamJPanel;
import view.ThongKeJPanel;
import view.TrangChuJPanel;

/**
 *
 * @author Acer-PC
 */
public class ChuyenManHinhController {
    private String kindSelected = "";
    private JPanel root;
    
    List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(0,102,102));
        jlbItem.setBackground(new Color(0,102,102));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    } 
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;   
            for(DanhMucBean item : listItem){
                item.getJlb().addMouseListener(new LabelEvent(item.getJpn(),item.getJlb(),item.getKind()));
            }
    }
    class LabelEvent implements  MouseListener {
        private JPanel node;
        private JPanel jpnItem;
        private JLabel jlbItem;
        private String kind;

        public LabelEvent(JPanel jpnItem, JLabel jlbItem, String kind) {
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
            this.kind = kind;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "CongNhan":
                    node = new CongNhanJPanel(); 
                    break;
                case "SanPham" :
                    node = new SanPhamJPanel();
                    break;
                case "Cong" :
                    node = new CongJPanel();
                    break;
                case "ThongKe":
                    node = new ThongKeJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeColor(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(0, 255, 204));
            jlbItem.setBackground(new Color(0, 255, 204));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(102, 255, 153));
            jlbItem.setBackground(new Color(102, 255, 153));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(0,102,102));
                jlbItem.setBackground(new Color(0,102,102));
            }
        }
        
    }
    
    private void setChangeColor(String kind){
        for(DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(0, 255, 204));
                item.getJlb().setBackground(new Color(0, 255, 204));
            }else{
                item.getJpn().setBackground(new Color(0,102,102));
                item.getJlb().setBackground(new Color(0,102,102));
            }
        }
    }
}
