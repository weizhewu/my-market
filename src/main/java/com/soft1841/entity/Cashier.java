package com.soft1841.entity;

public class Cashier {
    private Long id;
    private String name;
    private String number;
    private String password;
    private String varchar;

    public Cashier (Long id, String name, String number, String password, String varchar) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.password = password;
        this.varchar = varchar;
    }

    public Cashier() {

    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getNumber () {
        return number;
    }

    public void setNumber (String number) {
        this.number = number;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getVarchar () {
        return varchar;
    }

    public void setVarchar (String varchar) {
        this.varchar = varchar;
    }

    public void setId(Integer id) {

    }
}
