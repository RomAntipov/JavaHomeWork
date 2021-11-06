package com.pb.antipov.hw6;

public class Animal {
    private String food;
    private String location;

    //Конструктор
    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public Animal() {

    }

    //Геттеры и сеттеры
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //Методы класса
    public void makeNoise(){
        System.out.println("Животное издает звук.");
    }

    public void eat(){
        System.out.println("Животное кушает.");
    }

    public void sleep(){
        System.out.println("Животное спит.");
    }
}
