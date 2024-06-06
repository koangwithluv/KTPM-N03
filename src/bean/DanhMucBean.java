/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Acer-PC
 */
public class DanhMucBean {
    private String kind;
    private JLabel jlb;
    private JPanel jpn;

    public DanhMucBean() {
    }

    public DanhMucBean(String kind, JLabel jlb, JPanel jpn) {
        this.kind = kind;
        this.jlb = jlb;
        this.jpn = jpn;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
    
}
