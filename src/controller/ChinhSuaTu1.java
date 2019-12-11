/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTextField;
import model.Infomation;
import view.ThaoTacVoiTu;

/**
 *
 * @author ADMIN
 */
public class ChinhSuaTu1 {
    public  void showTu
        (JTextField txtTu,JTextField txtNghia,JTextField txtPhienAm,JTextField txtPhanLoai,JTextField txtLinkToFile,JTextField txtLinkToImage,JTextField txtGoiY,JTextField txtHashTag){
       
            int selectedRow=ThaoTacVoiTu.row;
        Infomation s=DAO.list.get(selectedRow);
        txtTu.setText(s.getTu());
        txtNghia.setText(s.getNghia());
        txtPhienAm.setText(s.getPhienAm());
        txtPhanLoai.setText(s.getPhanLoai());
        txtLinkToFile.setText(s.getLinkToFile());
        txtLinkToImage.setText(s.getLinkToImage());
        txtGoiY.setText(s.getGoiY());
        txtHashTag.setText(s.getHashTag());
        
        txtLinkToFile.setEditable(false);
        txtLinkToImage.setEditable(false);
        
    }
        
    public void update
        (Infomation s,JTextField txtTu,JTextField txtNghia,JTextField txtPhienAm,JTextField txtPhanLoai,JTextField txtLinkToFile,JTextField txtLinkToImage,JTextField txtGoiY,JTextField txtHashTag){
        int selectedRow=ThaoTacVoiTu.row;
        
        s.setTu(txtTu.getText());
        s.setNghia(txtNghia.getText());
        s.setPhienAm(txtPhienAm.getText());
        s.setPhanLoai(txtPhanLoai.getText());
        s.setLinkToFile(txtLinkToFile.getText());
        s.setLinkToImage(txtLinkToImage.getText());
        s.setGoiY(txtGoiY.getText());
        s.setHashTag(txtHashTag.getText());
        System.out.println(s.toString());
        DAO.list.set(selectedRow, s);
        
        
        
        
        
    }
}
