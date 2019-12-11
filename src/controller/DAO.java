/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Infomation;
import sun.applet.Main;

/**
 *
 * @author ADMIN
 */
public class DAO {
    private Connection conn;
    public static ArrayList<Infomation> list = new ArrayList<>();
    public  DAO(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection
        ("jdbc:sqlserver://localhost:1433;databasename=tbInfomation;username=admin;password=admin");
            System.out.println("Connect successfull!!!");
        } catch (Exception e) {
            System.out.println("Connect error!!!");
        }
    }
    
    public boolean addTu(Infomation a){
        String sql="INSERT INTO tbInfo(tu,nghia,phienAm,phanLoai,linkToFile,linkToImage,goiY,hashTag)"+
                "VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,a.getTu());
            ps.setString(2,a.getNghia());
            ps.setString(3,a.getPhienAm());
            ps.setString(4,a.getPhanLoai());
            ps.setString(5,a.getLinkToFile());
            ps.setString(6,a.getLinkToImage());
            ps.setString(7,a.getGoiY());
            ps.setString(8,a.getHashTag());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
         return false;
        
        
    }
    
    public ArrayList<Infomation> getListInfo(){
        String sql="SELECT * FROM tbInfo";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Infomation s=new Infomation();
                s.setTu(rs.getString("tu"));
                s.setNghia(rs.getString("nghia"));
                s.setPhienAm(rs.getString("phienAm"));
                s.setPhanLoai(rs.getString("phanLoai"));
                s.setLinkToFile(rs.getString("linkToFile"));
                s.setLinkToImage(rs.getString("linkToImage"));
                s.setGoiY(rs.getString("goiY"));
                s.setHashTag(rs.getString("hashTag"));
                
                list.add(s);
                
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    
    public boolean xoaTu(Infomation s){
        try {
            String sql="DELETE FROM tbInfo WHERE tu=\'"+s.getTu()+"\'";
            Statement ps = conn.createStatement();
            ps.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return false;
    }
    
     public boolean capNhatTu(Infomation s,String name){
        try {
            System.out.println("name:"+name);
            String sql="UPDATE [dbo].[tbInfo] "
                    + "SET "
                    + "tu=\'"+s.getTu()+"\',"
                    + "nghia=\'"+s.getNghia()+"\',"
                    + "phienAm=\'"+s.getPhienAm()+"\',"
                    + "phanLoai=\'"+s.getPhanLoai()+"\',"
                    + "linkToFile=\'"+s.getLinkToFile()+"\',"
                    + "linkToImage=\'"+s.getLinkToImage()+"\',"
                    + "goiY=\'"+s.getGoiY()+"\',"
                    + "hashTag=\'"+s.getHashTag()+"\'"
                    + "WHERE tu=\'"+name+"\'";
            Statement ps = conn.createStatement();
            ps.execute(sql);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return false;
    }
     
     
    
    
   
  
}
