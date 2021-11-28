package com.pb.antipov.hw10;

import com.pb.antipov.hw8.Auth;
import sun.reflect.generics.tree.Wildcard;

import java.lang.reflect.WildcardType;

public class Main {
    public static void main(String[] args) throws FullArrayException, EmptyArrayException {
        NumBox<Integer> numBox1 = new NumBox<>(3);
        NumBox<Float> numBox2 = new NumBox<>(5);

        try {
            numBox1.add(12);
            numBox1.add(5);
            numBox1.add(1001);

            numBox2.add(0.18f);
            numBox2.add(100.15f);
            numBox2.add(31.5f);
            numBox2.add(345.12f);
            //numBox2.add(872.0f);

            numBox1.add(2); // бросает исключение

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Возвращаем 1-e число numBox1 по индексу 0: "+numBox1.get(0));
        System.out.println("Возвращаем 3-e число numBox1 по индексу 2: "+numBox1.get(2));
        System.out.println("Возвращаем 2-e число numBox2 по индексу 1: "+numBox2.get(1));
        System.out.println("Возвращаем 5-e число numBox2 по индексу 4: "+numBox2.get(4));
        System.out.println("------------------------------------------------");

        System.out.println("Количество элементов в массиве numBox1:" + numBox1.length());
        System.out.println("Количество элементов в массиве numBox2:" + numBox2.length());
        System.out.println("------------------------------------------------");

        System.out.println("Среднее арифметическое элементов массива numBox1:" + numBox1.average());
        System.out.println("Среднее арифметическое элементов массива numBox2:" + numBox2.average());
        System.out.println("------------------------------------------------");

        System.out.println("Сумма элементов массива numBox1:" + numBox1.sum());
        System.out.println("Сумма элементов массива numBox2:" + numBox2.sum());
        System.out.println("------------------------------------------------");

        System.out.println("Максимальное значение элементов массива numBox1:" + numBox1.max());
        System.out.println("Максимальное значение элементов массива numBox2:" + numBox2.max());
        System.out.println("------------------------------------------------");
    }
}
