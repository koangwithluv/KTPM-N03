/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ThongKeDao;
import dao.ThongKeDaoImpl;
import model.CongNhan;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeDao thongKeDao = null;

    public ThongKeServiceImpl() {
        this.thongKeDao = new ThongKeDaoImpl();
    }
    
    @Override
    public int TongNhanVien() {
        return thongKeDao.TongNhanVien();
    }

    @Override
    public int TongSanPham() {
        return thongKeDao.TongSanPham();
    }

    @Override
    public int TongSanPhamSX() {
        return thongKeDao.TongSanPhamSX();
    }

    @Override
    public double TongLuong() {
        return thongKeDao.TongLuong();
    }

    @Override
    public CongNhan CNMaxLuong() {
        return thongKeDao.CNMaxLuong();
    }

    @Override
    public CongNhan CNMInLuong() {
        return thongKeDao.CNMInLuong();
    }

    @Override
    public SanPham spSanXuatMax() {
    return thongKeDao.spSanXuatMax();
    }

    @Override
    public SanPham SpSanXuatMin() {
    return thongKeDao.SpSanXuatMin();
    }
    
}
