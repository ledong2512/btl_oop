/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

/**
 *
 * @author ADMIN
 */
public class xuLyData {
    public boolean phatAmTu(String namePath){
        System.out.println("link:"+namePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(namePath);
            Player player = new Player((fileInputStream));
           
            player.play();
            return true;
        } catch (Exception ex) {
          
            return false;
        }
        
    }
    
    
}
