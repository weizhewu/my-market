package com.soft1841.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cashier {
   private final SimpleLongProperty id = new SimpleLongProperty();
   private final SimpleStringProperty name = new SimpleStringProperty();
   private final SimpleStringProperty number = new SimpleStringProperty();
   private final SimpleStringProperty password = new SimpleStringProperty();

    public Cashier(Long id, String number, String name, String password, String picture) {
    }

    public Cashier() {

    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "id=" + id +
                ", name=" + name +
                ", number=" + number +
                ", password=" + password +
                '}';
    }
}
