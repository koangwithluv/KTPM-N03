/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.SanPham;
import java.util.List;
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
public class SanPhamDaoIpml implements SanPhamDao{

    @Override
    public List<SanPham> getList() {
        List<SanPham> listSanPham = new ArrayList<>();
        Connection cons = null;
        PreparedStatement ps = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "select*from SanPham";
            
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getInt("SanPhamID"),rs.getString("TenSanPham"),rs.getDouble("DonGia"));
                listSanPham.add(sp);
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
        return listSanPham;
    }

   
    @Override
    public int crearOrUpdate(SanPham sanPham) {
        Connection cons = null;
        PreparedStatement ps = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "INSERT OR REPLACE INTO SanPham ( SanPhamID,TenSanPham,DonGia ) " +
                         "VALUES (?, ?, ?);";
            
            ps = cons.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,sanPham.getMaSanPham() );
            ps.setString(2, sanPham.getTenSanPham());
            ps.setDouble(3, sanPham.getDonGia());
           
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
            
            String sql = "delete from SanPham where SanPhamID = ? ;";
            
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
