package com.pb.antipov.hw5;

public class Library {
    public static void main(String[] args) {
        Reader person1 = new Reader("Оливер Вуд", 11111, "Гриффиндор", "01.01.1975", "0999999999");
        Reader person2 = new Reader("Седрик Диггори", 111222, "Пуффендуй", "01.09.1977", "0987654321");
        Reader person3 = new Reader("Полумна Лавгуд", 111333, "Когтевран", "13.02.1981", "0876545678");
        Reader person4 = new Reader("Драко Малфой", 111444,"Слизерин","05.06.1980","0955555555");
        Reader person5 = new Reader("Беллатриса Лестрейндж", 111555, "Слизерин", "01.01.1951","0966565646");

        Book book1 = new Book("«Властелин колец»", "Дж. Р.Р. Толкин",1954);
        Book book2 = new Book("«Гордость и предубеждение»", "Джейн Остин", 1813);
        Book book3 = new Book("«Тёмные начала»", "Филип Пулман", 1995);
        Book book4 = new Book("«Автостопом по галактике»", "Дуглас Адамс", 1979);
        Book book5 = new Book("«Гарри Поттер и Кубок огня»", "Джоан Роулинг", 2000);

        //Выводим список книг
        System.out.println("\nКниги в наличии:");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
        book4.printInfo();
        book5.printInfo();

        //Выводим список читателей
        System.out.println("\nЗарегистрированные читатели:");
        person1.printInfo();
        person2.printInfo();
        person3.printInfo();
        person4.printInfo();
        person5.printInfo();

        //Демонстрация метода takeBook()
        System.out.println("");
        //Читатель взял N книг
        person1.takeBook(31);
        //Читатель взял перечень наименований книг
        person2.takeBook(book1.getName(), book2.getName(), book3.getName());
        //Читатель взял книги с полной информацией (автор, год издания)
        person3.takeBook(book1, book5);

        //Демонстрация метода returnBook()
        System.out.println("");
        //Читатель вернул N книг
        person4.returnBook(5);
        //Читатель вернул перечень  наименовай книг
        person5.returnBook(book3.getName(), book1.getName(), book5.getName());
        //Читатель вернул книги (автор, год издания)
        person3.returnBook(book2, book4, book5);

    }
}
