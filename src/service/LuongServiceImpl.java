/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.LuongDao;
import dao.LuongDaoImpl;
import java.util.List;
import model.Luong;

/**
 *
 * @author Admin
 */
public class LuongServiceImpl implements LuongService{
    private LuongDao luongDao = null;

    public LuongServiceImpl() {
        this.luongDao = new LuongDaoImpl();
    }
    
    @Override
    public List<Luong> listLuong() {
        return luongDao.listLuong();
    }
   
}
