package com.example.tour.domain;

import com.example.tour.AbstractEvent;

public class TourReserved extends AbstractEvent { //PetReserved
    Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    private int orderQuantity; //appearance
    public int getOrderQuantity() {
        return orderQuantity;
    }
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }


    String countryName;
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    String type;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    private int price = 0; // energy
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        
        this.price = price;
    }

}
