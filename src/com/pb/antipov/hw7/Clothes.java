package com.pb.antipov.hw7;

public abstract class Clothes {
    Size size;
    float price;
    String color;

    public Clothes(Size size, float price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}
