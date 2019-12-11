/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author ADMIN
 */
public class test {
    public static void main(String[] args) {
        try {
            
        
       FileInputStream fileInputStream = new FileInputStream("C:/Users/ADMIN/Downloads/translate_tts.mp3");
        Player player = new Player((fileInputStream));
            System.out.println("Start:");
        player.play();
        System.out.println("Song is playing");
        } catch (Exception e) {
        }
    }
}
