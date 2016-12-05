package com.example.sv_2016.beorder_visitor_v0.models;

import android.widget.TextView;

/**
 * Created by sv-2016 on 03/12/16.
 */
public class Histori {

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getHistoriDate() {
        return historiDate;
    }

    public void setHistoriDate(String historiDate) {
        this.historiDate = historiDate;
    }

    public String getHistoriTotal() {
        return historiTotal;
    }

    public void setHistoriTotal(String historiTotal) {
        this.historiTotal = historiTotal;
    }

    public Integer getRestoPhoto() {
        return restoPhoto;
    }

    public void setRestoPhoto(Integer restoPhoto) {
        this.restoPhoto = restoPhoto;
    }

    public Histori(String restoName, String historiDate, String historiTotal, Integer restoPhoto) {

        this.restoName = restoName;
        this.historiDate = historiDate;
        this.historiTotal = historiTotal;
        this.restoPhoto = restoPhoto;
    }

    private String restoName,historiDate,historiTotal;
    private Integer restoPhoto;


}
