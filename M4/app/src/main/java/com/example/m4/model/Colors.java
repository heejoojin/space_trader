package com.example.m4.model;

public enum Colors {
    BLUE("Blue"), GREEN("Green"), RED("Red"), YELLOW("Yellow"), GREY("Grey"),
    PURPLE("Purple"), PINK("Pink"), ORANGE("Orange"), WHITE("White"), BLACK("Black");

    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
