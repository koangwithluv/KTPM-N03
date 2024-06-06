/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Luong;


/**
 *
 * @author Admin
 */
public class LuongDaoImpl implements LuongDao{

    @Override
    public List<Luong> listLuong() {
        List<Luong> listLuong = new ArrayList<>();
        Connection cons = null;
        PreparedStatement ps = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "SELECT\n" +
"    nv.NhanVienID,\n" +
"    nv.HoTen,\n" +
"    SUM(nsp.SoLuong * sp.DonGia) AS TongLuong,\n" +
"    SUM(nsp.SoLuong) AS TongSoLuong\n" +
"FROM\n" +
"    NhanVien nv\n" +
"INNER JOIN\n" +
"    NhanVien_SanPham nsp ON nv.NhanVienID = nsp.NhanVienID\n" +
"INNER JOIN\n" +
"    SanPham sp ON nsp.SanPhamID = sp.SanPhamID\n" +
"GROUP BY\n" +
"    nv.NhanVienID, nv.HoTen;";
            
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Luong luong = new Luong(rs.getDouble("TongLuong"), rs.getInt("TongSoLuong"), rs.getString("HoTen"), rs.getInt("NhanVienID"));
                listLuong.add(luong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CongNhanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(cons != null){
                try {
                    cons.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(ps != null ){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CongNhanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return listLuong;
    }
    
}
