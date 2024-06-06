/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.CongNhan;

/**
 *
 * @author Acer-PC
 */
public interface CongNhanDao {
    public List<CongNhan> getList();
    public int creatOrUpdate(CongNhan congNhan);
    public int delete(int id);
}
