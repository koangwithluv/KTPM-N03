/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.CongNhan;
import model.SanPham;

/**
 *
 * @author Admin
 */
public interface ThongKeService {
     public int TongNhanVien();
    public int TongSanPham();
    public int TongSanPhamSX();
    public double TongLuong();
    public CongNhan CNMaxLuong();
    public CongNhan CNMInLuong();
    public SanPham spSanXuatMax();
    public SanPham SpSanXuatMin();
}
