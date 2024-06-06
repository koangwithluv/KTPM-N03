/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Luong extends CongNhan{
    private double luong;
    private int soluong;

    public Luong(double luong, int soluong, String fullName, String GioiTinh, String DiaChi, String Sdt, String Email, int maCN) {
        super(fullName, GioiTinh, DiaChi, Sdt, Email, maCN);
        this.luong = luong;
        this.soluong = soluong;
    }

    public Luong(double luong, int soluong, String fullName, int maCN) {
        super(fullName, maCN);
        this.luong = luong;
        this.soluong = soluong;
    }

    public Luong() {
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Luong(double luong, int soluong) {
        this.luong = luong;
        this.soluong = soluong;
    }
    
   

    
     
}
