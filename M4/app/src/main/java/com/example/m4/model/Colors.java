package com.example.m4.model;

/**
 * Enumerated class that establishes all the colors that we may end up using within the
 */
public enum Colors {
    BLUE("Blue"), GREEN("Green"), RED("Red"), YELLOW("Yellow"), GREY("Grey"),
    PURPLE("Purple"), PINK("Pink"), ORANGE("Orange"), WHITE("White"), BLACK("Black"),
    NAVY("Navy"), BURGUNDY("Burgundy");

    private String color;

    /**
     * Constructor setting the color
     * @param color
     */
    Colors(String color) {
        this.color = color;
    }

    //getter and setter for the color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Overridden toString method
     * @return the color currently set
     */
    @Override
    public String toString() {
        return color;
    }
}
