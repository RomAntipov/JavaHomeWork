package com.pb.antipov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userLogin;
        String userPassword;
        String userConfirmPassword;

        try {
            System.out.println("Пройдите регистацию.");
            System.out.println("Укажите логин от 5 до 20 символов. Должен содержать латинские буквы и цифры.");
            userLogin = scan.nextLine();
            System.out.println("Введите пароль. Минимум 5 символов. Может содержать латинские буквы, цифры, нижнее подчеркивание.");
            userPassword = scan.nextLine();
            System.out.println("Повторите пароль для подтверждения");
            userConfirmPassword = scan.nextLine();

            Auth auth = new Auth(userLogin, userPassword, userConfirmPassword);

            System.out.println("Выполните вход. Укажите ваш логин:");
            userLogin = scan.nextLine();
            System.out.println("Введите пароль:");
            userPassword = scan.nextLine();

            auth.signIn(userLogin, userPassword);

        } catch (Auth.WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (Auth.WrongPasswordException e) {
            System.out.println(e.getMessage());
        }




    }
}
