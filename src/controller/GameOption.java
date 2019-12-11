/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Infomation;

/**
 *
 * @author ADMIN
 */
public class GameOption {
    public Infomation getInfo(){
       String name=Play_Game.nameString;
       
       for(Infomation s:DAO.list){
           if(s.getTu().equals(name)){
               
               return s;
           }
       }
       return null;
       
       
    }
    
}
