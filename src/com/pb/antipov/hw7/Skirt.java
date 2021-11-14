package com.pb.antipov.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size size, float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Название: юбка, размер: " + this.size + " ("+ this.size.getDescription() + ", euro: " +
                this.size.getEuroSize() + ")" + ", цена: " + this.price + " ₴, цвет: "+ this.color);
    }
}
