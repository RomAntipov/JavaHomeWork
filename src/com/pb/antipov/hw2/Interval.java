package com.pb.antipov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Укажите целое число");
        int num1 = scan.nextInt();

        if(num1 >= 0 && num1 <= 14){
            System.out.println("Число находится в интервале [0-14]");
        } else if (num1 >= 15 && num1 <= 35) {
            System.out.println("Число находится в интервале [15-35]");
        } else if (num1 >= 36 && num1 <= 50) {
            System.out.println("Число находится в интервале [36-50]");
        } else if (num1 > 50 && num1 <= 100) {
            System.out.println("Число находится в интервале [51-100]");
        } else {
            System.out.println("Число не принадлежит интервалу [0-100]");
        }
    }
}
