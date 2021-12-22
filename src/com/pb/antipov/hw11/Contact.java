package com.pb.antipov.hw11;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.time.Period.between;

public class Contact implements Serializable {
    private String name;
    private LocalDate birthDate;
    private Set<String> phoneNumber = new HashSet<>();
    private String address;
    private LocalDateTime modifyDate;
    private LocalDateTime createDate = LocalDateTime.now();


    public Contact(String name, LocalDate birthDate, Set<String> phoneNumber, String address, LocalDateTime modifyDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.modifyDate = modifyDate;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber.add(phoneNumber);
    }

    public Contact() {
    }

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

    public Set<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void addPhoneNumber(String p) {
        this.phoneNumber.add(p);
    }

    public void setPhoneNumber(Set<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return  "ФИО: " + name +
                ", Номер телефона: " + phoneNumber +
                ", Дата Рождения: " + birthDate +
                ", Адрес: " + address + '.'
                ;
    }

    public String description() {
        if(birthDate != null & address != null & modifyDate != null){
            return  "ФИО: " + name +
                    ", Номер телефона: " + phoneNumber +
                    ", Дата Рождения: " + birthDate +
                    ", Адрес: " + address +
                    ", Дата редактирования " + modifyDate + '.'
                    ;
        } else if (birthDate != null & address != null){
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
