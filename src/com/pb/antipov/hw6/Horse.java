package com.pb.antipov.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private boolean isRacing;
    private String color;

    //Конструктор
    public Horse(String food, String location, boolean isRacing, String color) {
        super(food, location);
        this.isRacing = isRacing;
        this.color = color;
    }

    public Horse() {
        super();
    }

    //Геттеры и сеттеры
    public boolean isRacing() {
        return isRacing;
    }

    public void setRacing(boolean racing) {
        isRacing = racing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Переопределяем методы
    @Override
    public void makeNoise() {
        System.out.println("Лошадь фыркает");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь кушает");
    }

    @Override
    public void sleep() {
        System.out.println("Лошадь спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return isRacing == horse.isRacing && Objects.equals(color, horse.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRacing, color);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "isRacing=" + isRacing +
                ", color='" + color + '\'' +
                '}';
    }
}
