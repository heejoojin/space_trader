package com.example.m4.model;

import java.io.Serializable;

/**
 * Item class that represents a singular item such as water.
 * Contains specifications such as its value
 * and amount the user owns
 */
public class Item implements Serializable {

    private final String name;
    private int quantityOwned;
    private int quantityChange;
    private final int price;
    private int quantityInMarket;

    private int beforeUpdateOwned;
    private int beforeUpdateInMarket;

    /**
     * Constructor to set up the name of the item and its preliminary price
     * @param name name of the item
     * @param price price of the item
     */
    @SuppressWarnings("MagicNumber")
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
     * @return String of name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of the iten that the player owns
     * @return inf of quantity owned
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
     * @return int of price of item
     */
    public int getPrice() {
        return price;
    }


    /**
     * getter method for QuantityInMarket
     * @return int of quantityInMarket
     */
    public int getQuantityInMarket() {
        return quantityInMarket;
    }

    /**
     * getter method for QuantityChange
     * @return int of Quantitychange
     */
    public int getQuantityChange(){
        return quantityChange;
    }

    /**
     * Increase quantityChange
     */
    public void addToQuantityChange() {
        this.quantityChange += 1;
    }

    /**
     * Increase beforeUpdateOwned
     */
    public void addToQuanitiyinHold() {

        this.beforeUpdateOwned += 1;
    }

    /**
     * Decrease beforeUpdatedOwned
     */
    public void removeFromQuantityinHold() {

        if (this.beforeUpdateOwned >= 1){
            this.beforeUpdateOwned -= 1;
        }
    }

    /**
     * Decrease quantityChange
     */
    public void removeFromQuantityChange(){
        if (this.quantityChange >= 1){
            this.quantityChange -= 1;
        }
    }

    /**
     * increase beforeUpdatedInMarket
     */
    public void addToQuantityinMarket() {

        this.beforeUpdateInMarket += 1;

    }

    /**
     * decrease beforeUpdateInMarket
     */
    public void removeFromQuantityinMarket() {

        if (this.beforeUpdateInMarket >= 1) {
            this.beforeUpdateInMarket -= 1;

        }
    }

    /**
     * setter method for quantitychange
     * @param quantityChange int of quantityChange
     */
    public void setQuantityChange(int quantityChange) {
        this.quantityChange = quantityChange;
    }

}
