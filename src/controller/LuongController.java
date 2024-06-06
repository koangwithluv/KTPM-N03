/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.CongNhan;
import model.Luong;

import service.LuongService;
import service.LuongServiceImpl;
import utiliti.ClassTableModel;
import view.CongNhanJFrame;

/**
 *
 * @author Admin
 */
public class LuongController {
    
    private JTextField jtfSearch;
    private JPanel jpnView;
    
    private LuongService luongService = null;
    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;
    
    private int id;
    
    private String[] listColumn = {"Mã Công Nhân", "STT", "Họ và tên", "Tổng số lượng sản phẩm làm được", "Lương"};

    public LuongController(JPanel jpnView,  JTextField jtfSearch) {
        this.jpnView = jpnView;
        
        this.jtfSearch = jtfSearch;
        
        this.luongService = new LuongServiceImpl();
        this.classTableModel = new ClassTableModel();
    }

    public LuongController() {
    }
    public void setDataToTable(){
        List<Luong> listLuong = luongService.listLuong();
        
        DefaultTableModel model = classTableModel.setTableLuong(listLuong, listColumn);       
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
}
