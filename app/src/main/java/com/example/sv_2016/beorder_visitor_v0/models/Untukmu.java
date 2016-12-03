package com.example.sv_2016.beorder_visitor_v0.models;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class Untukmu {

    private String restoName,notifDate,notifContent;

    public Untukmu(String restoName, String notifDate, String notifContent) {
        this.restoName = restoName;
        this.notifDate = notifDate;
        this.notifContent = notifContent;
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

    public String getNotifContent() {
        return notifContent;
    }

    public void setNotifContent(String notifContent) {
        this.notifContent = notifContent;
    }
}
