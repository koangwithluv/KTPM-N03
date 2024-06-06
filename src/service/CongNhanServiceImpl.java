/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import dao.CongNhanDao;
import dao.CongNhanDaoImpl;
import java.util.List;
import model.CongNhan;

/**
 *
 * @author Acer-PC
 */
public class CongNhanServiceImpl implements CongNhanService{
    private CongNhanDao congNhanDao = null;
    

    public CongNhanServiceImpl() {
    this.congNhanDao = new CongNhanDaoImpl();
    }
    
    @Override
    public List<CongNhan> getList() {
        return congNhanDao.getList();
    }

    @Override
    public int creatOrUpdate(CongNhan congNhan) {
        return congNhanDao.creatOrUpdate(congNhan);
    }

    @Override
    public int delete(int id) {
        return congNhanDao.delete(id);
    }
    
}
