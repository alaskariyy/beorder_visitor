package com.example.sv_2016.beorder_visitor_v0.models;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class Struk {

    private String restoName,notifDate,strukTotal;

    public Struk(String restoName, String notifDate, String strukTotal) {
        this.restoName = restoName;
        this.notifDate = notifDate;
        this.strukTotal = strukTotal;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getNotifDate() {
        return notifDate;
    }

    public void setNotifDate(String notifDate) {
        this.notifDate = notifDate;
    }

    public String getStrukTotal() {
        return strukTotal;
    }

    public void setStrukTotal(String strukTotal) {
        this.strukTotal = strukTotal;
    }
}
