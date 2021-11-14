package com.pb.antipov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(Size size, float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Название: мужская футболка, размер: " + this.size + " ("+ this.size.getDescription() + ", euro: " +
                this.size.getEuroSize() + ")" + ", цена: " + this.price + " ₴, цвет: "+ this.color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Название: женская футболка, размер: " + this.size + " ("+ this.size.getDescription() + ", euro: " +
                this.size.getEuroSize() + ")" + ", цена: " + this.price + " ₴, цвет: "+ this.color);
    }
}
