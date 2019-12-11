/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Infomation {
    private String tu;
    private String nghia;
    private String phienAm;
    private String phanLoai;
    private String linkToFile;
    private String linkToImage;
    private String goiY;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
    private int temp;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    private String hashTag;
    private String tempTime;
    private String time;
    Date date;
    SimpleDateFormat format,formatTime;
    public Infomation(){
        date=new Date();
        format =new SimpleDateFormat("dd/MM/yyyy");
        formatTime=new SimpleDateFormat("HH:mm:ss");
        setTempTime(format.format(date));
        setTime(formatTime.format(date));
        setTemp(0);
    }

    public String getTempTime() {
        return tempTime;
    }
    
    public void setTempTime(String tempTime) {
        this.tempTime = tempTime;
    }
   

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getPhienAm() {
        return phienAm;
    }

    public void setPhienAm(String phienAm) {
        this.phienAm = phienAm;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public void setLinkToImage(String linkToImage) {
        this.linkToImage = linkToImage;
    }

    public String getGoiY() {
        return goiY;
    }

    public void setGoiY(String goiY) {
        this.goiY = goiY;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    @Override
    public String toString() {
        return "Infomation{" + "tu=" + tu + ", nghia=" + nghia + ", phienAm=" + phienAm + ", phanLoai=" + phanLoai + ", linkToFile=" + linkToFile + ", linkToImage=" + linkToImage + ", goiY=" + goiY + ", hashTag=" + hashTag + ", tempTime=" + tempTime + ",temp="+temp+'}';
    }
    
    
    
    
    
}
