package com.example.m4.model;

import java.io.Serializable;

public class Item implements Serializable {

    private  String name;
    private int quantityOwned;
    private int quantityChange;
    private int price;
    private int quantityInMarket;

    private int beforeUpdateOwned;
    private int beforeUpdateInMarket;

    public void setQuantityChange(int quantityChange) {
        this.quantityChange = quantityChange;
    }

    public Item(String name, int price) {
        this.name = name;
        this.quantityOwned = 0;
        this.price = price * (1 + (int)(Math.random() * (6 - 1)));
        this.quantityChange = 0;
        this.quantityInMarket = 5 + (int)(Math.random() * (51 - 5));
        this.beforeUpdateInMarket = this.quantityInMarket;
        this.beforeUpdateOwned = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOwned() {
        return quantityOwned;
    }

    public void updateQuantity() {
        this.quantityOwned = this.beforeUpdateOwned;
        this.quantityInMarket = this.beforeUpdateInMarket;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantityInMarket() {
        return quantityInMarket;
    }

    public int getQuantityChange(){
        return quantityChange;
    }

    public void addToQuantityChange() {
        this.quantityChange += 1;
    }

    public void addToQuanitiyinHold() {
        //this.quantityOwned += 1;
        this.beforeUpdateOwned += 1;
    }

    public void removeFromQuantityinHold() {
//        if (this.quantityOwned >= 1){
//            this.quantityOwned -= 1;
//        }

        if (this.beforeUpdateOwned >= 1){
            this.beforeUpdateOwned -= 1;
        }
    }

    public void removeFromQuantityChange(){
        if (this.quantityChange >= 1){
            this.quantityChange -= 1;
        }
    }

    public void addToQuantityinMarket() {
        // this.quantityInMarket += 1;

        this.beforeUpdateInMarket += 1;

    }

    public void removeFromQuantityinMarket() {
//        if (this.quantityInMarket >= 1){
//            this.quantityInMarket -= 1;
//        }

        if (this.beforeUpdateInMarket >= 1) {
            this.beforeUpdateInMarket -= 1;

        }
    }

}
