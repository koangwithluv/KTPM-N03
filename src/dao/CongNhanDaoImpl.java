/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.CongNhan;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Acer-PC
 */
public class CongNhanDaoImpl implements CongNhanDao{
    

    @Override
    public List<CongNhan> getList() {
        List<CongNhan> listCongNhan = new ArrayList<>();
        Connection cons = null;
        PreparedStatement ps = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "select*from NhanVien";
            
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CongNhan cn = new CongNhan(rs.getString("HoTen"),rs.getString("GioiTinh"),rs.getString("DiaChi"),rs.getString("SoDienThoai"),rs.getString("Email"),rs.getInt("NhanVienID"));
                listCongNhan.add(cn);
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
        return listCongNhan;
    }

    @Override
    public int creatOrUpdate(CongNhan congNhan) {
        
        Connection cons = null;
        PreparedStatement ps = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "INSERT OR REPLACE INTO NhanVien (HoTen, NhanVienID, DiaChi, SoDienThoai, Email, GioiTinh) " +
                         "VALUES (?, ?, ?, ?, ?, ?);";
            
            ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(2, congNhan.getMaCN() );
            ps.setString(1, congNhan.getFullName());
            ps.setString(3, congNhan.getDiaChi());
            ps.setString(4, congNhan.getSdt());
            ps.setString(5, congNhan.getEmail());
            ps.setString(6, congNhan.getGioiTinh());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            int generrateKey = 0;
            if(rs.next()){
                generrateKey = rs.getInt(1);
            }
            return generrateKey;
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
        return 0;
    }

    @Override
    public int delete(int id) {
        Connection cons = null;
        PreparedStatement ps = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "delete from NhanVien where NhanVienID = ? ;";
            
            ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, id);            
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            int generrateKey = 0;
            if(rs.next()){
                generrateKey = rs.getInt(1);
            }
            return generrateKey;
            
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
        return 0;
    }
    

}
