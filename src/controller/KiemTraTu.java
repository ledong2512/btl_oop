/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.ThaoTacVoiTu;



/**
 *
 * @author ADMIN
 */
public class KiemTraTu {
    public void checkTu(JTextField txtTu){
        String tu=txtTu.getText().toString();
        for (int j=0;j<tu.length();j++) {
            if(!('a'<=tu.charAt(j)&&tu.charAt(j)<='z')&&!(tu.charAt(j)==' '))
                if(!('A'<=tu.charAt(j)&&tu.charAt(j)<='z')){
                    JOptionPane.showMessageDialog(null, "Từ và cụm từ bạn không phải tiếng anh");
                    ThaoTacVoiTu.temp=1;
                    break;
                }
    }
    }
    
    public void checkLoaiTu(JTextField txtPhanLoai){
        String ploaiTu1=txtPhanLoai.getText().toString();
        String ploaiTu=ploaiTu1.toLowerCase();
        if(!ploaiTu.equals("adv")&&!ploaiTu.equals("adj")&&!
            ploaiTu.equals("n")&&!ploaiTu.equals("v")&&!
            ploaiTu.equals("np")&&!ploaiTu.equals("vp")&&!
            ploaiTu.equals("idioms")&&!ploaiTu.equals("clause")){
            JOptionPane.showMessageDialog(null,"Loại từ bạn điền không hợp lệ");
             ThaoTacVoiTu.temp=2;
        }
    }
    
}
