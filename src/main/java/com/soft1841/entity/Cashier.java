package com.soft1841.entity;

public class Cashier {
    private Long id;
    private String name;
    private String number;
    private String password;
    private String avatar;

    public Cashier() {
    }

    public Cashier(Long id, String name, String number, String password, String avatar) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.password = password;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return id + " " + name+" " +  number +" "+ password +" "+avatar;
    }
}
