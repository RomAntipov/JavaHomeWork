package com.pb.antipov.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {

    public Pants(Size size, float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Название: мужские брюки, размер: " + this.size + " ("+ this.size.getDescription() + ", euro: " +
                this.size.getEuroSize() + ")" + ", цена: " + this.price + " ₴, цвет: "+ this.color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Название: женские брюки, размер: " + this.size + " ("+ this.size.getDescription() + ", euro: " +
                this.size.getEuroSize() + ")" + ", цена: " + this.price + " ₴, цвет: "+ this.color);
    }

}
