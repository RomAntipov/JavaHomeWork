package com.pb.antipov.hw5;

public class Book {
    private String bookName;
    private String bookAuthor;
    private int bookDate;

    public Book(String bookName, String bookAuthor, int bookDate) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDate = bookDate;
    }
    public Book() {

    }

    public void setName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setDate(int bookDate) {
        this.bookDate = bookDate;
    }

    public String getName() {
        return bookName;
    }

    public String getAuthor() {
        return bookAuthor;
    }

    public int getDate() {
        return bookDate;
    }

    public String getInfo(){
        return bookName+" ("+bookAuthor+", "+bookDate+")";
    }

    public void printInfo(){
        System.out.println(bookName+" ("+bookAuthor+", "+bookDate+")");

    }
}
