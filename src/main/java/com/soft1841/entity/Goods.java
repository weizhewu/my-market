package com.soft1841.entity;

public class Goods {
    private int id;
    private double type_id;
    private String name;
    private double price;
    private String picture;
    private double stock;
    private String discription;

    public Goods(int id, double type_id, String name, double price, String picture, double stock, String discription) {
        this.id = id;
        this.type_id = type_id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.stock = stock;
        this.discription = discription;
    }

    public Goods() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getType_id() {
        return type_id;
    }

    public void setType_id(double type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {this.discription = discription;}

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", type_id=" + type_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", stock=" + stock +
                ", discription='" + discription + '\'' +
                '}';
    }

    public long getLong(String id) {
        return 0;
    }
}