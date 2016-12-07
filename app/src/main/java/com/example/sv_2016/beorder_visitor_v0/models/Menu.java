package com.example.sv_2016.beorder_visitor_v0.models;

/**
 * Created by sv-2016 on 05/12/16.
 */
public class Menu {

    private String orderHarga;
    private Integer orderImage;

    public String getOrderHarga() {
        return orderHarga;
    }

    public void setOrderHarga(String orderHarga) {
        this.orderHarga = orderHarga;
    }

    public Integer getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(Integer orderImage) {
        this.orderImage = orderImage;
    }

    public Menu(String orderHarga, Integer orderImage) {

        this.orderHarga = orderHarga;
        this.orderImage = orderImage;
    }
}
