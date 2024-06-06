/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author Acer-PC
 */
public class CongNhan {
    private String fullName,GioiTinh,DiaChi, Sdt, Email;
    private int maCN;

    public CongNhan(String fullName, String GioiTinh, String DiaChi, String Sdt, String Email, int maCN) {
        this.fullName = fullName;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.maCN = maCN;
    }

    public CongNhan(String fullName, int maCN) {
        this.fullName = fullName;
        this.maCN = maCN;
    }

    public int getMaCN() {
        return maCN;
    }

    public void setMaCN(int maCN) {
        this.maCN = maCN;
    }
    

    public CongNhan() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "fullName : " + fullName + ", maCN : " + maCN ;
    }

    
    
    
}