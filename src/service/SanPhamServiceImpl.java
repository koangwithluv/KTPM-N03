/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import dao.SanPhamDao;
import dao.SanPhamDaoIpml;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Acer-PC
 */
public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamDao sanPhamDao = null;

    public SanPhamServiceImpl(){
        this.sanPhamDao = new SanPhamDaoIpml();
    }

    @Override
    public List<SanPham> getList() {
        return sanPhamDao.getList();
    }
    

    @Override
    public int creatOrUpdate(SanPham sanPham) {
        return sanPhamDao.crearOrUpdate(sanPham);
    }

    @Override
    public int delete(int id) {
        return sanPhamDao.delete(id);
    }
}
