package com.pb.antipov.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private boolean hasCollar;
    private boolean isDomestic;
    private int catchedPostmans;

    //Контсрукторы
    public Dog(String food, String location, boolean hasCollar, boolean isDomestic) {
        super(food, location);
        this.hasCollar = hasCollar;
        this.isDomestic = isDomestic;
        this.catchedPostmans = catchedPostmans;
    }

    public Dog() {
        super();
    }
    //Геттеры и сеттеры
    public boolean isHasCollar() {
        return hasCollar;
    }

    public void setHasCollar(boolean hasCollar) {
        this.hasCollar = hasCollar;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }

    public int getCatchedPostmans() {
        return catchedPostmans;
    }

    public void setCatchedPostmans(int catchedPostmans) {
        this.catchedPostmans = catchedPostmans;
    }

    //Переопределяем методы
    @Override
    public void makeNoise() {
        System.out.println("Собака гавкает");
    }

    @Override
    public void eat() {
        System.out.println("Собака кушает");
    }

    @Override
    public void sleep() {
        System.out.println("Собака спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return hasCollar == dog.hasCollar && isDomestic == dog.isDomestic && catchedPostmans == dog.catchedPostmans;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasCollar, isDomestic, catchedPostmans);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "hasCollar=" + hasCollar +
                ", isDomestic=" + isDomestic +
                ", catchedPostmans=" + catchedPostmans +
                '}';
    }
}
