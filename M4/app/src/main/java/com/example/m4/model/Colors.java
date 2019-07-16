package com.example.m4.model;

/**
 * Enumerated class that establishes all the colors that we may end up using within the
 */
@SuppressWarnings("unused")
public enum Colors {
    BLUE("Blue"), GREEN("Green"), RED("Red"), YELLOW("Yellow"), GREY("Grey"),
    PURPLE("Purple"), DARKGREEN("Dark Green"), ORANGE("Orange"), WHITE("White"),
    LIGHTORANGE("Light Orange"), NAVY("Navy"), BURGUNDY("Burgundy");

    private String color;

    /**
     * Constructor setting the color
     * @param color of enum string
     */
    Colors(String color) {
        this.color = color;
    }

    /**
     * Gets color
     * @return name of color
     */
    public String getColor() {
        return color;
    }


    /**
     * Sets color
     */
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
