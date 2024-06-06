/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer-PC
 */
public class SanPham {
    private String tenSanPham;
    private int maSanPham;
    private double donGia;

    public SanPham() {
    }

    public SanPham(String tenSanPham, int maSanPham) {
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
    }

    public SanPham(int maSanPham, String tenSanPham, double donGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "maSanPham : " + maSanPham + ", tenSanPham : " + tenSanPham ;
    }
    
}
