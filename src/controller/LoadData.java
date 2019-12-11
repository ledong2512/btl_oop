/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DAO.list;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Infomation;
import view.Main_View;
import view.ThaoTacVoiTu;

/**
 *
 * @author ADMIN
 */
public class LoadData {

    public static DefaultTableModel model;
    public void loadData(JTable table){
     
      model=(DefaultTableModel) table.getModel();
      model.setColumnIdentifiers(new Object[]
        {"STT","Từ/Cụm Từ","Nghĩa","Phiên Âm","Phân Loại","LinkToFile","LinkToImage","Gợi Ý","HashTag"});
    
    }
    
    public void showTable(Infomation s){
            int x=list.size();
            model.addRow(new Object[]
            {x++,s.getTu(),s.getNghia(),s.getPhienAm(),s.getPhanLoai(),s.getLinkToFile(),s.getLinkToImage(),s.getGoiY(),s.getHashTag()});
        
        
    }
    
    public static void loadDataFromList(){
        int i=1;
        
        for (Infomation s : list) {
           
              model.addRow(new Object[]
            {i++,s.getTu(),s.getNghia(),s.getPhienAm(),s.getPhanLoai(),s.getLinkToFile(),s.getLinkToImage(),s.getGoiY(),s.getHashTag()});
        
        }
    }
    
    public Infomation getDataFromUser
        (JTextField txtTu,JTextField txtNghia,JTextField txtPhienAm,JTextField txtPhanLoai,JTextField txtLinkToFile,JTextField txtLinkToImage,JTextField txtGoiY,JTextField txtHashTag){
        Infomation s= new Infomation();
        try {
        s.setTu(txtTu.getText());
        s.setNghia(txtNghia.getText());
        s.setPhienAm(txtPhienAm.getText());
        s.setPhanLoai(txtPhanLoai.getText());
        s.setLinkToFile(txtLinkToFile.getText());
        s.setLinkToImage(txtLinkToImage.getText());
        s.setGoiY(txtGoiY.getText());
        s.setHashTag(txtHashTag.getText());
        
        list.add(s);
        } catch (Exception e) {
            System.out.println(e);
        }
       
        return s;
    }
        public static void btnLoadData(JTextField txtPhatAm ){
            btnLoadData(txtPhatAm,0);
        }
         public static void btnLoadData(JTextField txtPhatAm, int Option ){
            try {
            JFileChooser fc=new JFileChooser();
            if (Option==0){
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter=new FileNameExtensionFilter("PNG/IMG", "png","img","jpg");
            fc.addChoosableFileFilter(filter);
            }
            else {
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter=new FileNameExtensionFilter("MP3 only", "mp3");
            fc.addChoosableFileFilter(filter);}
            if(fc.showOpenDialog(fc)==JFileChooser.APPROVE_OPTION){
                String namePath= fc.getSelectedFile().toURI().toString();
               txtPhatAm.setText(namePath.substring(6));
               txtPhatAm.setEditable(false);
            
        //FileInputStream fileInputStream = new FileInputStream(namePath.substring(6));
       // Player player = new Player((fileInputStream));
           
       // player.play();
        
            }
        
    }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Đường dẫn đến file không hợp lệ");
    }
        }
        
        public void xoaData(){
            Infomation s=DAO.list.get(ThaoTacVoiTu.row);
           if( Main_View.connectDao.xoaTu(s)==true){ 
               JOptionPane.showMessageDialog(null,"Xóa thành công!");
                list.remove(s);
           }else JOptionPane.showMessageDialog(null,"Xóa thất bại");
           
            
        }
}
