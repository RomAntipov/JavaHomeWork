package com.pb.antipov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import static java.time.Period.between;

public class Contact extends PhoneBook {
    private String name;
    private LocalDate birthDate;
    private HashSet<String> phoneNumber = new HashSet<>();
    private String address;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Contact(String name, LocalDate birthDate, String address, String phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber.add(phoneNumber);
        this.createDate = LocalDateTime.now();
    }

    public Contact(String name, LocalDate birthDate, String phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber .add(phoneNumber);
        this.createDate = LocalDateTime.now();
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber.add(phoneNumber);
        this.createDate = LocalDateTime.now();
    }

    public Contact() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;

    }

    public HashSet<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String p) {
        this.phoneNumber.add(p);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return  "ФИО: " + name +
                ", Номер телефона: " + phoneNumber +
                ", Дата Рождения: " + birthDate +
                ", Адрес: " + address + '.'
                ;
    }

    public String getInfo() {
        if(birthDate != null & address != null){
            return  "ФИО: " + name +
                    ", Номер телефона: " + phoneNumber +
                    ", Дата Рождения: " + birthDate +
                    ", Адрес: " + address + '.'
                    ;
        } else if (birthDate != null){
            return  "ФИО: " + name +
                    ", Номер телефона: " + phoneNumber +
                    ", Дата Рождения: " + birthDate + '.'
                    ;
        } else if(address != null) {
            return  "ФИО: " + name +
                    ", Номер телефона: " + phoneNumber +
                    ", Адрес: " + address + '.'
                    ;
        } else {
            return  "ФИО: " + name +
                    ", Номер телефона: " + phoneNumber + '.'
                    ;
        }

    }


}
