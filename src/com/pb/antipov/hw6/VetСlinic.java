package com.pb.antipov.hw6;

import java.lang.reflect.*;
import java.util.Arrays;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Cat cat1 = new Cat("молоко", "квартира",false,10);
        Cat cat2 = new Cat("китикет", "дом", false,0);

        Dog dog1 = new Dog("мясо", "будка", true,true);
        Dog dog2 = new Dog("кости", "улица",true,false);

        Horse horse1 = new Horse("морковь", "конюшня", true, "вороная");
        Horse horse2 = new Horse("трава", "поле", false, "рыжая");

        Animal[] animals = {cat1,cat2,dog1,dog2,horse1,horse2};

        Class clazz = Class.forName("com.pb.antipov.hw6.Veterinarian");
        System.out.println(clazz.getName());
        System.out.println(Veterinarian.class);
        Method method2 = clazz.getDeclaredMethod("threatAnimal", Animal.class);

        method2.invoke(cat1);
    }
}
