/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiliti;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.CongNhan;
import model.Luong;
import model.SanPham;
/**
 *
 * @author Acer-PC
 */
public class ClassTableModel {
    public DefaultTableModel setTableCongNhan(List<CongNhan> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
                
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i =0 ; i < rows ; i++){
                CongNhan congNhan = listItem.get(i);
                obj = new Object[columns];
                obj[0] = congNhan.getMaCN();
                obj[1] = i+1    ;
                obj[2] = congNhan.getFullName();
                obj[3] = congNhan.getDiaChi();
                obj[4] = congNhan.getGioiTinh();
                obj[5] = congNhan.getEmail();
                obj[6] = congNhan.getSdt();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
    public DefaultTableModel setTableSanPham(List<SanPham> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
                
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i =0 ; i < rows ; i++){
                SanPham sanPham = listItem.get(i);
                obj = new Object[columns];
                obj[0] = sanPham.getMaSanPham();
                obj[1] = i+1    ;
                obj[2] = sanPham.getTenSanPham();
                obj[3] = sanPham.getDonGia();
                
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
    public DefaultTableModel setTableLuong(List<Luong> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
                
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i =0 ; i < rows ; i++){
                Luong luong = listItem.get(i);
                obj = new Object[columns];
                obj[0] = luong.getMaCN();
                obj[1] = i+1    ;
                obj[2] = luong.getFullName();
                obj[3] = luong.getSoluong();
                obj[4] = luong.getLuong();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
