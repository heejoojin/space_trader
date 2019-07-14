package com.example.m4.model;

import java.io.Serializable;

/**
 * Item class that represents a singular item such as water. Contains specifications such as its value
 * and amount the user owns
 */
public class Item implements Serializable {

    private String name;
    private int quantityOwned;
    private int quantityChange;
    private int price;
    private int quantityInMarket;

    private int beforeUpdateOwned;
    private int beforeUpdateInMarket;

    private int beforeUpdateQuantityLimited;

    /**
     * Constructor to set up the name of the item and its preliminary price
     * @param name name of the item
     * @param price price of the item
     */
    public Item(String name, int price) {
        this.name = name;
        this.quantityOwned = 0;
        this.price = price * (1 + (int)(Math.random() * (6 - 1)));
        this.quantityChange = 0;
        this.quantityInMarket = 5 + (int)(Math.random() * (51 - 5));
        this.beforeUpdateInMarket = this.quantityInMarket;
        this.beforeUpdateOwned = 0;
    }

    /**
     * Gets name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of the iten that the player owns
     */
    public int getQuantityOwned() {
        return quantityOwned;
    }

    /**
     * Updates the quantity the user owns
     */
    public void updateQuantity() {
        this.quantityOwned = this.beforeUpdateOwned;
        this.quantityInMarket = this.beforeUpdateInMarket;

    }

    /**
     * Gets the price of the item
     */
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

        this.beforeUpdateOwned += 1;
    }

    public void removeFromQuantityinHold() {

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

        this.beforeUpdateInMarket += 1;

    }

    public void removeFromQuantityinMarket() {

        if (this.beforeUpdateInMarket >= 1) {
            this.beforeUpdateInMarket -= 1;

        }
    }
    public void setQuantityChange(int quantityChange) {
        this.quantityChange = quantityChange;
    }

}
