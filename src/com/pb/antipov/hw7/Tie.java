package com.pb.antipov.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie(Size size, float price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Название: галстук, размер: " + this.size + " ("+ this.size.getDescription() + ", euro: " +
                this.size.getEuroSize() + ")" + ", цена: " + this.price + " ₴, цвет: "+ this.color);
    }

}
