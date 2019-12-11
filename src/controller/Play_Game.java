/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Button;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Infomation;
import view.Game;

/**
 *
 * @author ADMIN
 */
public class Play_Game {
    public static int indexSelect=-1;
    public static String nameString;
    Random rd=new Random();
     public static  int sizeShow;
    public static int index;
    public static ArrayList<Infomation> danhSach=new ArrayList<>();
    public void Play(int cheDo,String hint){
       
        if(cheDo==1){
            
            for (Infomation s : DAO.list) {
                if(s.getHashTag().equals(hint)){
                    danhSach.add(s);
                }
                
            }
            
        }else if(cheDo==2){
            
            for (Infomation s : DAO.list) {
                if(s.getTempTime().equals(hint)){
                    danhSach.add(s);
                }
                
            }
        }
        
        
    }
    
    public void PlayGame(JLabel label1){
        int cheDo=Game.selectOption;
        int length;
       
        int length1;
         String show=new String();
        
        if(cheDo==1||cheDo==2){
           
           length=danhSach.size();
            index=rd.nextInt(length);
           
            while(index==indexSelect){
                index=rd.nextInt(length);
            }
            nameString=danhSach.get(index).getTu();
            
            length1=nameString.length();
            sizeShow=0;
            for (int i = 0; i <length1 ; i++) {
                    if(i==0||i==length1-1){
                        show+=nameString.charAt(i);
                        sizeShow+=1;
                    }
                    else if(nameString.charAt(i)==' '){
                        show+=" ";
                    }else{
                        show+=" _ ";
                        sizeShow+=1;

                    }
                }
           
            label1.setText(show.toUpperCase());
             indexSelect=index;
             
            
        }else if(cheDo==3){
           length=DAO.list.size();
            index=rd.nextInt(length);
            while(index==indexSelect){
                index=rd.nextInt(length);
            }
            nameString=DAO.list.get(index).getTu();
            length1=nameString.length();
            sizeShow=0;
            for (int i = 0; i <length1 ; i++) {
                    if(i==0||i==length1-1){
                        show+=nameString.charAt(i);
                        sizeShow+=1;
                    }
                    else if(nameString.charAt(i)==' '){
                        show+=" ";
                    }else{
                        show+=" _ ";
                        sizeShow+=1;

                    }
                }
            label1.setText(show.toUpperCase());
            indexSelect=index;
           
            
        }
        
    }
    
    public Infomation PlayGameAI(JLabel label1,ArrayList<Infomation> listAI){
            int length=listAI.size();
            index=rd.nextInt(length);
            while(index==indexSelect){
                index=rd.nextInt(length);
            }
            Infomation sInfomation=listAI.get(index);
            indexSelect=index;
            return sInfomation;
                    
            
            
        
        
    }
    public String ketqua(){
        return nameString.toLowerCase();
    }
    public boolean kiemTraKetQua(JTextField textField){
        String ketQua=textField.getText();
        String a=ketQua.toLowerCase();
        String b=nameString.toLowerCase();
        if(a.equals(b))
            return true;
        else
            return false;
        
        
    }
    
    public String hoTro(String inputString,String outputString){
        String show=new String();
        int a=0;
        
       for (int i = 0; i <outputString.length(); i++) {
           try {
                if(inputString.charAt(i)==outputString.charAt(i))
                    show+="("+inputString.charAt(i)+")";
                else{
                    show+=outputString.charAt(i);
                }
                 } catch (Exception e) {
                     show+=outputString.charAt(i);
           }
            }
            return show;
    }
    
    public String LCS(String inputString,String outputString){
        int length=inputString.length();
        String name,result=new String();
        int size=0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                name=inputString.substring(i,j+1);
                if (outputString.indexOf(name)!=-1&&name.length()>size){
                    result=name;
                    size=name.length();
                    
                }
            }
        }
        return result;
        
        
    }
    
}
