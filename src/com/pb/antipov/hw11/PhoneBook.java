package com.pb.antipov.hw11;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.Level;

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
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Выберите действие");
            }
        }
    }



    private static void addContact(Scanner scan, LinkedList<Contact> phoneBook) {
        Contact p = new Contact();
        System.out.println("PhoneBook -> Добавить контакт");
        System.out.println("Укажите ФИО");
        p.setName(scan.nextLine());

        System.out.println("Укажите номер телефона: ");
        p.setPhoneNumber(scan.nextLine());

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
                    p.setPhoneNumber(scan.nextLine());
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
                System.out.println(i+". "+c.getInfo());
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
                    phoneBook.sort(Comparator.comparingInt(p -> between(LocalDate.now(), p.getBirthDate()).getYears()));
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
        while (true){
            System.out.println();
            System.out.println("PhoneBook -> Редактирование");
            System.out.println("Укажите номер записи для редактирования");
            int i = Integer.parseInt(scan.nextLine())-1;
            System.out.println(p.get(i));
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
                                p.get(i).setPhoneNumber(scan.nextLine());
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
                                    for (String phone : p.get(i).getPhoneNumber()) {
                                        int n = 0;
                                        phones[n] = phone;
                                        n++;
                                        System.out.println(n + ". " + phone);
                                    }
                                    int n = scan.nextInt() - 1;
                                    p.get(i).getPhoneNumber().remove(phones[n]);
                                    System.out.println("Укажите новый номер телефона");
                                    p.get(i).setPhoneNumber(scan.nextLine());
                                    p.get(i).setModifyDate(LocalDateTime.now());
                                } else {
                                    p.get(i).getPhoneNumber().clear();
                                    System.out.println("Укажите новый номер телефона");
                                    p.get(i).setPhoneNumber(scan.nextLine());
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
                    break;
                case "4":
                    System.out.println("Укажите новый адрес контакта");
                    p.get(i).setAddress(scan.nextLine());
                    p.get(i).setModifyDate(LocalDateTime.now());
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Выберите действие");
            }
        }
    }

    private static void saveToFile(LinkedList<Contact> phoneBook) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        String json = mapper.writeValueAsString(phoneBook);
        try {

            File file = Paths.get("files/person.data").toFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(json);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
//        // write to file
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src\\com\\pb\\antipov\\hw11\\PhoneBook.txt"))) {
//            writer.write(json);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
    }

    private static void loadFromFile(LinkedList<Contact> phoneBook) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        // read from file
        //Path path = Paths.get("src\\com\\pb\\antipov\\hw9\\PhoneBook.txt");

        try {

            File file = Paths.get("src\\com\\pb\\antipov\\hw11\\PhoneBook.txt").toFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            LinkedList<Contact> pb = (LinkedList<Contact>) objectInputStream.readObject();
            System.out.println(pb);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
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

