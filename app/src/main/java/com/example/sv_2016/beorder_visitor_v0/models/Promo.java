package com.example.sv_2016.beorder_visitor_v0.models;

/**
 * Created by sv-2016 on 24/11/16.
 */
public class Promo {
    private String restoName,postTime,restoPromo;
    private Integer restoPhoto,postPhoto;

    public Integer getRestoPhoto() {
        return restoPhoto;
    }

    public void setRestoPhoto(Integer restoPhoto) {
        this.restoPhoto = restoPhoto;
    }

    public Integer getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(Integer postPhoto) {
        this.postPhoto = postPhoto;
    }

    public Promo(String restoName, String postTime, String restoPromo, Integer restoPhoto, Integer postPhoto) {

        this.restoName = restoName;
        this.postTime = postTime;
        this.restoPromo = restoPromo;
        this.restoPhoto = restoPhoto;
        this.postPhoto = postPhoto;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getRestoPromo() {
        return restoPromo;
    }

    public void setRestoPromo(String restoPromo) {
        this.restoPromo = restoPromo;
    }
}
