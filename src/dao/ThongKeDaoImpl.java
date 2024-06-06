/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CongNhan;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class ThongKeDaoImpl implements ThongKeDao{

    public ThongKeDaoImpl() {
        
    }
    
    @Override
    public int TongNhanVien() {
         Connection cons = null;
        PreparedStatement ps = null;
        int total =0;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT COUNT(*) AS TongSoNhanVien FROM NhanVien;";
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            total = rs.getInt("TongSoNhanVien");
            
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
        return total;
    }

    @Override
    public int TongSanPham() {
        Connection cons = null;
        PreparedStatement ps = null;
        int total =0;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT COUNT(*) AS TongSP FROM SanPham;";
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            total = rs.getInt("TongSP");
            
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
        return total;    
    }

    @Override
    public int TongSanPhamSX() {
        Connection cons = null;
        PreparedStatement ps = null;
        int total =0;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT SUM(SoLuong) AS TongSLSP FROM NhanVien_SanPham;";
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            total = rs.getInt("TongSLSP");
            
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
        return total;
    }

    @Override
    public double TongLuong() {
         Connection cons = null;
        PreparedStatement ps = null;
        double total =0;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT SUM(nsp.SoLuong * sp.DonGia) AS TongLuongChiTra\n" +
                         "FROM NhanVien_SanPham nsp\n" +
                         "INNER JOIN SanPham sp ON nsp.SanPhamID = sp.SanPhamID;";
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            total = rs.getInt("TongLuongChiTra")/1000;
            
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
        return total;
    }

    @Override
    public CongNhan CNMaxLuong() {
        Connection cons = null;
        PreparedStatement ps = null;
        CongNhan cn = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT \n" +
"    nv.NhanVienID,\n" +
"    nv.HoTen,\n" +
"    SUM(nsp.SoLuong * sp.DonGia) AS TongLuong\n" +
"FROM \n" +
"    NhanVien nv\n" +
"INNER JOIN \n" +
"    NhanVien_SanPham nsp ON nv.NhanVienID = nsp.NhanVienID\n" +
"INNER JOIN \n" +
"    SanPham sp ON nsp.SanPhamID = sp.SanPhamID\n" +
"GROUP BY \n" +
"    nv.NhanVienID, nv.HoTen\n" +
"ORDER BY \n" +
"    TongLuong DESC\n" +
"LIMIT 1;" ;
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cn = new CongNhan(rs.getString("HoTen"),rs.getInt("NhanVienID"));
            
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
        return cn;
        
    }

    @Override
    public CongNhan CNMInLuong() {
        Connection cons = null;
        PreparedStatement ps = null;
        CongNhan cn = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT \n" +
"    nv.NhanVienID,\n" +
"    nv.HoTen,\n" +
"    SUM(nsp.SoLuong * sp.DonGia) AS TongLuong\n" +
"FROM \n" +
"    NhanVien nv\n" +
"INNER JOIN \n" +
"    NhanVien_SanPham nsp ON nv.NhanVienID = nsp.NhanVienID\n" +
"INNER JOIN \n" +
"    SanPham sp ON nsp.SanPhamID = sp.SanPhamID\n" +
"GROUP BY \n" +
"    nv.NhanVienID, nv.HoTen\n" +
"ORDER BY \n" +
"    TongLuong ASC\n" +
"LIMIT 1;" ;
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cn = new CongNhan(rs.getString("HoTen"),rs.getInt("NhanVienID"));
            
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
        return cn;
    }

    @Override
    public SanPham spSanXuatMax() {
        Connection cons = null;
        PreparedStatement ps = null;
        SanPham sp = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = " SELECT \n" +
"    sp.SanPhamID,\n" +
"    sp.TenSanPham,\n" +
"    SUM(nsp.SoLuong) AS TongSoLuong\n" +
"FROM \n" +
"    SanPham sp\n" +
"INNER JOIN \n" +
"    NhanVien_SanPham nsp ON sp.SanPhamID = nsp.SanPhamID\n" +
"GROUP BY \n" +
"    sp.SanPhamID, sp.TenSanPham\n" +
"ORDER BY \n" +
"    TongSoLuong DESC\n" +
"LIMIT 1;" ;
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            sp = new SanPham(rs.getString("TenSanPham"),rs.getInt("SanPhamID"));
            
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
        return sp;
    }

    @Override
    public SanPham SpSanXuatMin() {
         Connection cons = null;
        PreparedStatement ps = null;
        SanPham sp = null;
        try {
            cons = DBConnect.getConnection();
            
            String sql = "SELECT \n" +
"    sp.SanPhamID,\n" +
"    sp.TenSanPham,\n" +
"    SUM(nsp.SoLuong) AS TongSoLuong\n" +
"FROM \n" +
"    SanPham sp\n" +
"INNER JOIN \n" +
"    NhanVien_SanPham nsp ON sp.SanPhamID = nsp.SanPhamID\n" +
"GROUP BY \n" +
"    sp.SanPhamID, sp.TenSanPham\n" +
"ORDER BY \n" +
"    TongSoLuong ASC\n" +
"LIMIT 1;";
                        
            ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            sp = new SanPham(rs.getString("TenSanPham"),rs.getInt("SanPhamID"));
            
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
        return sp;
    }
    
}
