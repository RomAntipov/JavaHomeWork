package com.pb.antipov.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private boolean isCastrated;
    private int caughtMice;

    //конструктор
    public Cat(String food, String location, boolean isCastrated, int caughtMice) {
        super(food, location);
        this.isCastrated = isCastrated;
        this.caughtMice = caughtMice;
    }

    public Cat() {
        super();
    }

    //Геттеры и сеттеры
    public boolean isCastrated() {
        return isCastrated;
    }

    public void setCastrated(boolean castrated) {
        isCastrated = castrated;
    }

    public int getCaughtMice() {
        return caughtMice;
    }

    public void setCaughtMice(int caughtMice) {
        this.caughtMice = caughtMice;
    }

    //Переопределяем методы
    @Override
    public void makeNoise() {
        System.out.println("Кот мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кот кушает");
    }

    @Override
    public void sleep() {
        System.out.println("Кот спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return isCastrated == cat.isCastrated && caughtMice == cat.caughtMice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCastrated, caughtMice);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "isCastrated=" + isCastrated +
                ", caughtMice=" + caughtMice +
                '}';
    }


}
