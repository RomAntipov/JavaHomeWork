package com.pb.antipov.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String str1;
        String str2;
        String result;

        System.out.println("Является ли одна строка анаграммой другой строки?");
        System.out.println("Введите первую строку:");
        str1 = scan.nextLine();

        System.out.println("Введите вторую строку:");
        str2 = scan.nextLine();

        result = checkAnagram(str1, str2);
        System.out.println(result);

    }

    static String checkAnagram(String a, String b){
        char[] c = a.toLowerCase().replaceAll("(?U)\\W+", "").toCharArray();
        char[] d = b.toLowerCase().replaceAll("(?U)\\W+", "").toCharArray();

        sortArr(c);
        sortArr(d);
        if (Arrays.equals(c,d)){
            return "Первая строка является анаграммой второй строки";
        } else {
            return "Первая строка не является анаграммой второй строки";
        }
    }

   static char[] sortArr(char[] s){
        Arrays.sort(s);
        return s;
   }

}
