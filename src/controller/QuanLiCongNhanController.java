/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.CongNhan;
import service.CongNhanService;
import utiliti.ClassTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import service.CongNhanServiceImpl;
import view.CongNhanJFrame;
import view.CongNhanJPanel;


/**
 *
 * @author Acer-PC
 */
public class QuanLiCongNhanController {
    private JPanel jpnView;
    private JButton jbtnAdd;
    private JTextField jtfSearch;
    private JButton jbtnDelete;
    
    private CongNhanService congNhanService = null;
    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;
    
    private int id;
    
    private String[] listColumn = {"Mã Công Nhân", "STT", "Họ và tên", "Địa chỉ", "Giới Tính", "Email", "Sdt"};

    public QuanLiCongNhanController(JPanel jpnView, JButton jbtnAdd,JButton jbtnDelete, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jbtnAdd = jbtnAdd;
        this.jtfSearch = jtfSearch;
        this.jbtnDelete = jbtnDelete;
        
        this.congNhanService = new CongNhanServiceImpl();
        this.classTableModel = new ClassTableModel();
    }

    public QuanLiCongNhanController() {
    }
    public void setDataToTable(){
        List<CongNhan> listCongNhan = congNhanService.getList();
        
        DefaultTableModel model = classTableModel.setTableCongNhan(listCongNhan, listColumn);       
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectRowIndex = table.getSelectedRow();
                    selectRowIndex = table.convertRowIndexToModel(selectRowIndex);
                    
                    
                    CongNhan congNhan = new CongNhan();
                    congNhan.setFullName( (String) model.getValueAt(selectRowIndex, 2));
                    congNhan.setMaCN( (Integer) model.getValueAt(selectRowIndex, 0) );
                    congNhan.setGioiTinh( (String) model.getValueAt(selectRowIndex, 4));
                    congNhan.setDiaChi( (String) model.getValueAt(selectRowIndex, 3));
                    congNhan.setEmail((String) model.getValueAt(selectRowIndex, 5));
                    congNhan.setSdt((String) model.getValueAt(selectRowIndex, 6));
                    
                    CongNhanJFrame frame = new CongNhanJFrame(congNhan);
                    frame.setTitle("Thông Tin Công Nhân");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                }
                if(e.getClickCount() == 1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectRowIndex = table.getSelectedRow();
                    selectRowIndex = table.convertRowIndexToModel(selectRowIndex);
                    
                    Object value = model.getValueAt(selectRowIndex, 0);

                    if (value instanceof Integer) {
                                   id = (Integer) value;
                                } else if (value instanceof String) {
                                             id = Integer.parseInt((String) value);
                                } else {
                                // Xử lý nếu giá trị không phải là kiểu Integer hoặc String
                                 throw new IllegalArgumentException("Giá trị không phải là kiểu Integer hoặc String");
}
                    
                }
            }
        
        });
        
        
        table.getTableHeader().setFont(new Font("Arrial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(925, 600));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
    public void setEvent(){
        jbtnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                CongNhanJFrame frame = new CongNhanJFrame(new CongNhan());
                frame.setTitle("Thông Tin Học Viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnAdd.setBackground(new Color(0,204,153));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnAdd.setBackground(new Color(0,153,153));
            }
            
        });
        
        jbtnDelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1){
                congNhanService.delete(id);
                QuanLiCongNhanController controller = new  QuanLiCongNhanController(jpnView, jbtnAdd,jbtnDelete, jtfSearch);
                controller.setDataToTable();
                }
                if(e.getClickCount() == 2){
                congNhanService.delete(id);
                QuanLiCongNhanController controller = new  QuanLiCongNhanController(jpnView, jbtnAdd,jbtnDelete, jtfSearch);
                controller.setDataToTable();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnAdd.setBackground(new Color(0,204,153));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbtnAdd.setBackground(new Color(0,153,153));
            }
            
        });
    }
    
}
