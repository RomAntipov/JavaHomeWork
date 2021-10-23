package com.pb.antipov.hw4;

import java.util.Locale;
import java.util.Scanner;

public class CapitalLetter {

    static String toUpCase (String s) {
        StringBuilder strBuilder = new StringBuilder();
        String[] a = s.split("\\s");
        for (int i=0; i<a.length; i++){
            String b = a[i];
            int len = b.length();
            String c = b.substring(0,1).toUpperCase()+b.substring(1, len);
            strBuilder.append(" "+c);
        }
        return strBuilder.toString().trim();
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;

        System.out.println("Введите текст");
        str = scan.nextLine();

        String resStr = toUpCase(str);
        System.out.println(resStr);
    }
}
