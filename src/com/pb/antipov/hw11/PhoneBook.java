package com.pb.antipov.hw11;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


import static java.time.Period.between;

public class PhoneBook {
    static LinkedList<Contact> phoneBook = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println();
            System.out.println("PhoneBook");
            System.out.println("1. Просмотреть все контакты");
            System.out.println("2. Добавить контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Найти контакт");
            System.out.println("5. Отсортировать по полю ...");
            System.out.println("6. Редактировать контакт");
            System.out.println("7. Записать все контакты в файл");
            System.out.println("8. Загрузить контакты из файла");
            System.out.println("9. Exit");
            String option = scan.nextLine();

            switch (option) {
                case "1":
                    showContacts(phoneBook);
                    break;
                case "2":
                    addContact(scan, phoneBook);
                    break;
                case "3":
                    deleteContact(scan, phoneBook);
                    break;
                case "4":
                    findContacts(scan, phoneBook);
                    break;
                case "5":
                    sort(scan, phoneBook);
                    break;
                case "6":
                    modifyContact(scan,phoneBook);
                    break;
                case "7":
                    saveToFile(phoneBook);
                    break;
                case "8":
                    loadFromFile(phoneBook);
                    break;
                case "9":
                    System.out.println("Работа с приложением завершена!");
                    return;
                default:
                    System.out.println("Выберите действие");
            }
        }
    }



    private static void addContact(Scanner scan, LinkedList<Contact> phoneBook) {
        System.out.println("PhoneBook -> Добавить контакт");
        System.out.println("Укажите ФИО");
        String fio = scan.nextLine();

        System.out.println("Укажите номер телефона: ");
        String phone = scan.nextLine();

        Contact p = new Contact(fio,phone);

        while (true) {
            System.out.println();
            System.out.println("PhoneBook -> Добавить контакт");
            System.out.println("1. Добавить номер телефона контакту " + p.getName());
            System.out.println("2. Добавить дату рождения " + p.getName());
            System.out.println("3. Добавить адрес");
            System.out.println("4. Сохранить");
            System.out.println("5. Отменить");


            String option = scan.nextLine();
            switch (option) {
                case "1":
                    System.out.println("PhoneBook -> Добавить контакт -> Добавить номер телефона");
                    System.out.println("Укажите номер телефона: ");
                    p.addPhoneNumber(scan.nextLine());
                    break;
                case "2":
                    System.out.println("PhoneBook -> Добавить контакт -> Добавить дату рождения");
                    System.out.println("Укажите дату рождения (dd.mm.yyyy) контакта " + p.getName());
                    String date = scan.nextLine();
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        LocalDate bDate = LocalDate.parse(date,formatter);
                        p.setBirthDate(bDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Неверный формат даты");
                    }
                    break;
                case "3":
                    System.out.println("PhoneBook -> Добавить контакт -> Добавить адрес");
                    System.out.println("Укажите адрес контакта " + p.getName());
                    p.setAddress(scan.nextLine());
                    break;
                case "4":
                    phoneBook.add(p);
                    System.out.println("Контакт " + p.getName() + " успешно добавлен!");
                    showContacts(phoneBook);
                    return;
                case "5":
                    System.out.println("Добавление контакта отменено!");
                    showContacts(phoneBook);
                    return;
                default:
                    System.out.println("Выберите действие");
            }
        }
    }

    private static void showContacts(LinkedList<Contact> phoneBook) {
        if (phoneBook.isEmpty()){
            System.out.println("Нет записей");
        }else {
            System.out.println("PhoneBook -> Все контакты");
            int i = 1;
            for (Contact c : phoneBook) {
                System.out.println(i+". "+c.description());
                i++;
            }
        }
    }

    private static void deleteContact(Scanner scan, LinkedList<Contact> phoneBook) {
        try {
            System.out.println();
            System.out.println("Укажите номер записи контакта для удаления (\"-1\" для отмены операции).");
            int i = Integer.parseInt(scan.nextLine());
            if (i == -1) return;
            else if (i <= phoneBook.size() & i != 0) phoneBook.remove(i-1);
            else System.out.println("Запись с таким номером не найдена");
        } catch (Exception e){
            System.out.println("Запись с таким номером не найдена");
        }
    }

    private static void sort(Scanner scan, LinkedList<Contact> phoneBook){
        while (true){
            System.out.println();
            System.out.println("PhoneBook -> Сортировка");
            System.out.println("1. По дате рождения");
            System.out.println("2. По дате добавления контакта");
            System.out.println("3. По алфавиту");
            System.out.println("4. Назад");

            String option = scan.nextLine();
            switch (option) {
                case "1":
                    phoneBook.sort(Comparator.comparingInt(p -> {
                        LocalDate date = p.getBirthDate();
                        if (p.getBirthDate() == null) date = LocalDate.of(1900,1,1);
                        Period years = between(LocalDate.now(), date);
                        return years.getYears();
                    }));
                    showContacts(phoneBook);
                    System.out.println("\nСписок контактов отсортирован по дате рождения");
                    break;
                case "2":
                    phoneBook.sort(Comparator.comparing(p -> p.getCreateDate()));
                    showContacts(phoneBook);
                    System.out.println("\nСписок контактов отсортирован по дате добавления");
                    break;
                case "3":
                    phoneBook.sort(Comparator.comparing(p -> p.getName()));
                    showContacts(phoneBook);
                    System.out.println("\nСписок контактов отсортирован по алфавиту");
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Выберите действие");
            }
        }
    }

    private static void modifyContact(Scanner scan, LinkedList<Contact> p){
        showContacts(p);
        while (true){
            int i;
            try {
                System.out.println();
                System.out.println("PhoneBook -> Редактирование");
                System.out.println("Укажите номер записи для редактирования");
                i = Integer.parseInt(scan.nextLine())-1;
                System.out.println(p.get(i));
            } catch (Exception e) {
                System.out.println("Неверно указан номер записи");
                return;
            }
            System.out.println("Выберите поле для редактирования");
            System.out.println("1. ФИО");
            System.out.println("2. Номер телефона");
            System.out.println("3. Дата рождения");
            System.out.println("4. Адрес");
            System.out.println("5. Вернуться в меню");

            String option = scan.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Укажите новое имя контакта");
                    p.get(i).setName(scan.nextLine());
                    p.get(i).setModifyDate(LocalDateTime.now());
                    break;
                case "2":
                    while (true) {
                        System.out.println("PhoneBook -> Редактирование -> Номер телефона");
                        System.out.println("Выберите действие с номером телефона");
                        System.out.println("1. Добавить");
                        System.out.println("2. Удалить");
                        System.out.println("3. Редактировать");
                        System.out.println("4. Назад");

                        String rdn = scan.nextLine();
                        switch (rdn) {
                            case "1":
                                System.out.println("Укажите номер телефона для добавления");
                                p.get(i).addPhoneNumber(scan.nextLine());
                                p.get(i).setModifyDate(LocalDateTime.now());
                                break;
                            case "2":
                                if (p.get(i).getPhoneNumber().size() == 1) p.get(i).getPhoneNumber().clear();
                                else {
                                        System.out.println("Укажите номер записи телефона для удаления");
                                        String[] phones = new String[p.get(i).getPhoneNumber().size()];
                                        for (String phone : p.get(i).getPhoneNumber()) {
                                            int n = 0;
                                            phones[n] = phone;
                                            n++;
                                            System.out.println(n + ". " + phone);
                                        }
                                        p.get(i).getPhoneNumber().remove(phones[Integer.parseInt(scan.nextLine())-1]);

                                    }
                                p.get(i).setModifyDate(LocalDateTime.now());
                                break;
                            case "3":
                                if (p.get(i).getPhoneNumber().size() > 1) {
                                    System.out.println("Укажите номер записи телефона для редактирования");
                                    String[] phones = new String[p.get(i).getPhoneNumber().size()];
                                    int n = 0;
                                    for (String phone : p.get(i).getPhoneNumber()) {
                                        phones[n] = phone;
                                        n++;
                                        System.out.println(n + ". " + phone);
                                    }
                                    try {
                                        n = Integer.parseInt(scan.nextLine())-1;
                                    } catch (Exception e) {
                                        System.out.println("Неверно указан номер записи");
                                        return;
                                    }
                                    p.get(i).getPhoneNumber().remove(phones[n]);
                                    System.out.println("Укажите новый номер телефона");
                                    String ph = scan.nextLine();
                                    p.get(i).addPhoneNumber(ph);
                                    p.get(i).setModifyDate(LocalDateTime.now());
                                } else {
                                    p.get(i).getPhoneNumber().clear();
                                    System.out.println("Укажите новый номер телефона");
                                    p.get(i).addPhoneNumber(scan.nextLine());
                                    p.get(i).setModifyDate(LocalDateTime.now());
                                }
                                break;
                            case "4":
                                return;
                        }
                    }
                case "3":
                    System.out.println("Укажите новую дату рождения контакта");
                    String date = scan.nextLine();
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        LocalDate bDate = LocalDate.parse(date,formatter);
                        p.get(i).setBirthDate(bDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Неверный формат даты");
                    }
                    p.get(i).setModifyDate(LocalDateTime.now());
                    return;
                case "4":
                    System.out.println("Укажите новый адрес контакта");
                    p.get(i).setAddress(scan.nextLine());
                    p.get(i).setModifyDate(LocalDateTime.now());
                    return;
                case "5":
                    return;
                default:
                    System.out.println("Выберите действие");
            }
        }
    }

    private static void findContacts (Scanner scan, LinkedList<Contact> phoneBook){
        System.out.println("Введите имя для поиска");
        String f = scan.nextLine();
        for (Contact c : phoneBook) {
            if(c.getName().contains(f)){
                System.out.println(c);
            }
        }
    }

    private static void saveToFile(LinkedList<Contact> phoneBook) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate
        SimpleModule module1 = new SimpleModule();
        SimpleModule module2 = new SimpleModule();
        module1.addSerializer(LocalDate.class, new LocalDateSerializer());
        module2.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        mapper.registerModule(module1);
        mapper.registerModule(module2);

        String json = mapper.writeValueAsString(phoneBook);
        FileWriter myWriter = new FileWriter("src\\com\\pb\\antipov\\hw11\\Phones.txt");

        try {
            myWriter.write(json);
            System.out.println("Экспорт контактов в файл успешно завершен!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally {
            myWriter.close();
        }
    }

    private static void loadFromFile(LinkedList<Contact> phoneBook) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // для работы с полями типа LocalDate
        SimpleModule module1 = new SimpleModule();
        SimpleModule module2 = new SimpleModule();
        module1.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module2.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module1);
        mapper.registerModule(module2);

        BufferedReader br = new BufferedReader(new FileReader("src\\com\\pb\\antipov\\hw11\\Phones.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            List<Contact> contacts = mapper.readValue(everything, new TypeReference<LinkedList<Contact>>() {});
//            for (Contact p: persons3) {
//                phoneBook.add(p);
//            }
            contacts.stream().forEach(p -> {phoneBook.add(p);});
        } finally {
            br.close();
            System.out.println("Импорт контактов завершен");
        }

    }

    public static class LocalDateDeserializer extends StdDeserializer<LocalDate> {

        private static final long serialVersionUID = 1L;

        protected LocalDateDeserializer() {
            super(LocalDate.class);
        }


        @Override
        public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(jp.readValueAs(String.class));
        }
    }

    public static class LocalDateSerializer extends StdSerializer<LocalDate> {

        private static final long serialVersionUID = 1L;

        public LocalDateSerializer(){
            super(LocalDate.class);
        }

        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider sp) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }
    public static class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

        private static final long serialVersionUID = 2L;

        public LocalDateTimeSerializer(){
            super(LocalDateTime.class);
        }

        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider sp) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }
    public static class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

        private static final long serialVersionUID = 2L;

        protected LocalDateTimeDeserializer() {
            super(LocalDateTime.class);
        }

        @Override
        public LocalDateTime deserialize(JsonParser jp, DeserializationContext cnxt) throws IOException {
            return LocalDateTime.parse(jp.readValueAs(String.class));
        }
    }





}




// Пользователь может выбрать такие действия:
//1. Просмотреть контакты
//2. Добавить контакты
//3. Удалить контакт
//4. Найти контакт
//5. Отсортировать по полю ...
//6. Редактировать контакт
//7. Записать все контакты в файл
//8. Загрузить контакты из файла

