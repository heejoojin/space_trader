package com.example.m4.model;

import java.io.Serializable;

public class Item implements Serializable {

    private  String name;
    private int quantityLeft;
    private int quantityChange;
    private int price;

    public void setQuantityChange(int quantityChange) {
        this.quantityChange = quantityChange;
    }

    public Item(){}

    public Item(String name, int quantityLeft, int price) {
        this.name = name;
        this.quantityLeft = quantityLeft;
        this.price = price;
        this.quantityChange = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantityChange(){
        return quantityChange;
    }

    public void addToQuantity() {
        if (this.quantityChange >= 1){
            this.quantityLeft += 1;
            this.quantityChange -= 1;
        }
    }

    public void removeFromQuantity(){
        if (this.quantityLeft >= 1){
            this.quantityLeft -= 1;
            this.quantityChange += 1;
        }

    }

}
