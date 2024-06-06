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
import utiliti.ClassTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import model.SanPham;
import service.SanPhamService;
import service.SanPhamServiceImpl;
import view.SanPhamJFrame;
/**
 *
 * @author Acer-PC
 */
public class QuanLiSanPhamController {
    private JButton jbtnAdd;
    private JButton jbtnDelete;
    private JPanel jpnView;
    private JTextField jtfSearch;
    
    private SanPhamService sanPhamService = null;
    private ClassTableModel tableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;
    
    int id ;
    private String[] listColumn = {"Mã Sản Phẩm", "STT", "Tên Sản Phẩm", "Đơn Giá"};

    public QuanLiSanPhamController(JButton jbtnAdd, JButton jbtnDelete, JPanel jpnView, JTextField jtfSearch) {
        this.jbtnAdd = jbtnAdd;
        this.jbtnDelete = jbtnDelete;
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        
        this.sanPhamService = new SanPhamServiceImpl();
        this.tableModel = new ClassTableModel();
        
    }
    public void setDataToTable(){
        List<SanPham> listSanPham = sanPhamService.getList();
        
        DefaultTableModel model = tableModel.setTableSanPham(listSanPham, listColumn);
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
                    
                    
                    SanPham sanPham = new SanPham();
                    
                    sanPham.setMaSanPham( Integer.parseInt( model.getValueAt(selectRowIndex, 0).toString()) );
                    sanPham.setTenSanPham( model.getValueAt(selectRowIndex, 2).toString());
                    System.out.println(sanPham.getTenSanPham());
                    sanPham.setDonGia(Double.parseDouble( model.getValueAt(selectRowIndex, 3).toString()));
                    
                    SanPhamJFrame frame = new SanPhamJFrame(sanPham);
                    frame.setTitle("Thông Tin Sản Phẩm");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                }
                if(e.getClickCount() == 1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectRowIndex = table.getSelectedRow();
                    selectRowIndex = table.convertRowIndexToModel(selectRowIndex);
                    
                    Object obj = model.getValueAt(selectRowIndex, 0);
                    id = Integer.parseInt(obj.toString());
                   
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
        scrollPane.setPreferredSize(new Dimension(900, 600));

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
                SanPhamJFrame frame = new SanPhamJFrame(new SanPham());
                frame.setTitle("Thông Tin Sản Phẩm");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbtnAdd.setBackground(new Color(255,255,255));
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
                sanPhamService.delete(id);
                QuanLiSanPhamController controller = new  QuanLiSanPhamController(jbtnAdd,jbtnDelete,jpnView,jtfSearch);
                controller.setDataToTable();
                }
                if(e.getClickCount() == 2){
                sanPhamService.delete(id);
                QuanLiSanPhamController controller = new  QuanLiSanPhamController(jbtnAdd,jbtnDelete,jpnView,jtfSearch);
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
