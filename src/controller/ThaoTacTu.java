/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Infomation;

/**
 *
 * @author ADMIN
 */
public class ThaoTacTu {
    
    
    public Infomation timKiem(String nameTu){
    
            for (Infomation lst : DAO.list){
                if(nameTu.equals(lst.getTu()))
                    return lst;
            }
        JOptionPane.showMessageDialog(null, "Không Tìm thấy!");
        return null;
    }
    
    public void suaTu(String nameOld,Infomation s){
        try {
            
            for (Infomation lst: DAO.list) {
                if(nameOld.equals(lst.getTu())==true) {
                               lst=s;
                               break;
                            }
            }
            JOptionPane.showMessageDialog(null, "Sửa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!");
        }
    }
    
    public void xoaTu(String name){
        try {
            for (Infomation lst : DAO.list) {
                if(name.equals(lst.getTu())==true) {
                    DAO.list.remove(lst);
                    break;
                            }
            }
            JOptionPane.showMessageDialog(null, "Xoa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!");
        }
    }
    
    
}
