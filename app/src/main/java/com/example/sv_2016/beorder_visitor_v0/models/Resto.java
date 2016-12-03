package com.example.sv_2016.beorder_visitor_v0.models;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class Resto {
    private String restoName,restoRegion,restoAddress,restoSeat,restoDistance;
    private Integer restoLogo,restoBanner;

    public Resto(String restoName, String restoRegion, String restoAddress, String restoSeat, String restoDistance, Integer restoLogo, Integer restoBanner) {
        this.restoName = restoName;
        this.restoRegion = restoRegion;
        this.restoAddress = restoAddress;
        this.restoSeat = restoSeat;
        this.restoDistance = restoDistance;
        this.restoLogo = restoLogo;
        this.restoBanner = restoBanner;
    }

    public String getRestoName() {
        return restoName;
    }

    public void setRestoName(String restoName) {
        this.restoName = restoName;
    }

    public String getRestoRegion() {
        return restoRegion;
    }

    public void setRestoRegion(String restoRegion) {
        this.restoRegion = restoRegion;
    }

    public String getRestoAddress() {
        return restoAddress;
    }

    public void setRestoAddress(String restoAddress) {
        this.restoAddress = restoAddress;
    }

    public String getRestoSeat() {
        return restoSeat;
    }

    public void setRestoSeat(String restoSeat) {
        this.restoSeat = restoSeat;
    }

    public String getRestoDistance() {
        return restoDistance;
    }

    public void setRestoDistance(String restoDistance) {
        this.restoDistance = restoDistance;
    }

    public Integer getRestoLogo() {
        return restoLogo;
    }

    public void setRestoLogo(Integer restoLogo) {
        this.restoLogo = restoLogo;
    }

    public Integer getRestoBanner() {
        return restoBanner;
    }

    public void setRestoBanner(Integer restoBanner) {
        this.restoBanner = restoBanner;
    }
}
