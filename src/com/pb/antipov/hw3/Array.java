package com.pb.antipov.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[10];
        int posNum = 0;
        int sum = 0;

        System.out.println("Введите 10 чисел через запятую");
        String[] arr = scan.nextLine().replaceAll("\\s", "").split(",");

        for(int i = 0; i < arr.length; i++){
            numbers[i] = Integer.parseInt(arr[i]);
            if(numbers[i] > 0){
                posNum++;
            }
        }
        for (int number : numbers) {
            sum = sum + number;
        }
        System.out.println("Одномерный массив: " + Arrays.toString(numbers));
        System.out.println("Cумма элементов массива: " + sum);
        System.out.println("Количество положительных элементов: " + posNum);

        boolean bubleSorted = false;
        boolean swapped;

        while(!bubleSorted){
            do{
                swapped = false;
                for (int n = 1; n < numbers.length; n++) {
                    int temp;
                    if (numbers[n - 1] > numbers[n]) {
                        temp = numbers[n - 1];
                        numbers[n - 1] = numbers[n];
                        numbers[n] = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
            bubleSorted = true;
        }

        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));


    }
}
