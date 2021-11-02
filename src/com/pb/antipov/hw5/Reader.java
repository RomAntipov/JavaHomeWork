package com.pb.antipov.hw5;

import java.util.Arrays;

public class Reader {
    private String fullName;
    private int libraryCardNumber;
    private String faculty;
    private String birthday;
    private String phoneNumber;

    // Конструкторы
    public Reader(String fullName, int libraryCardNumber, String faculty, String birthday, String phoneNumber) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public Reader() {

    }
    // Вывод информации о читателе
    public void printInfo(){
        System.out.println("ФИО: " + fullName + ", Номер читательского билета: " + libraryCardNumber +
                ", Факультет: " + faculty + ", Дата рождения: " + birthday + ", Номер телефона: " + phoneNumber);
    }

    //Перегруженный метод takeBook()
    public void takeBook(int q){
        if(q<1) {
            System.out.println("Читатель "+this.fullName + " не взял книг.");
        } else {
            System.out.println("Читатель "+this.fullName + " взял " + q + " " + pickPhrase(q)+".");
        }
    }

    public void takeBook(String... books){
        StringBuilder strBuilder = new StringBuilder("Читатель "+this.fullName + " взял книги: ");

        for(int i=0; i<books.length;i++){
            strBuilder.append(books[i]);
            if(i<books.length-1){ strBuilder.append(", ");} else {strBuilder.append(".");}
        }
        System.out.println(strBuilder);
    }


    public void takeBook(Book... books){
        StringBuilder strBuilder = new StringBuilder("Читатель "+this.fullName + " взял книги: ");

        for(int i=0; i<books.length;i++){
            strBuilder.append(books[i].getInfo());
            if(i<books.length-1){ strBuilder.append(", ");} else {strBuilder.append(".");}
        }
        System.out.println(strBuilder);
    }

    //Перегруженный метод returnBook()
    public void returnBook(int q){
        System.out.println("Читатель "+this.fullName + " вернул " + q + " "  + pickPhrase(q)+".");
    }

    public void returnBook(String... books){
        StringBuilder strBuilder = new StringBuilder("Читатель "+this.fullName + " вернул книги: ");

        for(int i=0; i<books.length;i++){
            strBuilder.append(books[i]);
            if(i<books.length-1){ strBuilder.append(", ");} else {strBuilder.append(".");}
        }
        System.out.println(strBuilder);
    }

    public void returnBook(Book... books){
        StringBuilder strBuilder = new StringBuilder("Читатель "+this.fullName + " вернул книги: ");

        for(int i=0; i<books.length;i++){
            strBuilder.append(books[i].getInfo());
            if(i<books.length-1){ strBuilder.append(", ");} else {strBuilder.append(".");}
        }
        System.out.println(strBuilder);
    }



    //подбор правильного окончания слова книга
    public static String pickPhrase(int count) {
        int rem = count % 100;
        if(rem < 11 || rem > 14){
            rem = count % 10;
            if(rem == 1) return "книгу";
            if(rem >= 2 && rem <= 4) return "книги";
        } return "книг";
    }

}
