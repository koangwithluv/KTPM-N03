/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;

/**
 *
 * @author Acer-PC
 */
public interface SanPhamService {
    public List<SanPham> getList();
    public int creatOrUpdate(SanPham sanPham);
    public int delete(int id);
}
