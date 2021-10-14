package com.pb.antipov.hw2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int operand1;
        int operand2;
        String sign;
        int res1;


        System.out.println("Укажите первое число:");
        operand1 = scan.nextInt();
        System.out.println("Укажите второе число:");
        operand2 = scan.nextInt();
        System.out.println("Укажите знак арифметической операции (+,-,/,*)");
        sign = scan.next();

        switch (sign){
            case "+":
                res1 = operand1 + operand2;
                System.out.println("Результат арифметической операции: " + res1);
                System.out.println(operand1+" "+sign+" "+operand2+" "+"="+" "+res1);
                break;
            case "-":
                res1 = operand1 - operand2;
                System.out.println("Результат арифметической операции: " + res1);
                System.out.println(operand1+" "+sign+" "+operand2+" "+"="+" "+res1);
                break;
            case "*":
                res1 = operand1 * operand2;
                System.out.println("Результат арифметической операции: " + res1);
                System.out.println(operand1+" "+sign+" "+operand2+" "+"="+" "+res1);
                break;
            case "/":
                if(operand2 == 0) {
                    System.out.println("На 0 делить нельзя");
                } else {
                    res1 = operand1 / operand2;
                    System.out.println("Результат арифметической операции: " + res1);
                    System.out.println(operand1+" "+sign+" "+operand2+" "+"="+" "+res1);
                }
                break;
            default:
                System.out.println("Недопустимая арифметическая операция");
        }

    }
}
