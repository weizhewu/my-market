package com.soft1841.entity;

/**
 * 商品类别类
 * 2018.12.26
 */

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Type {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();

    public Type () {
    }

    public long getId (String id) {
        return this.id.get();
    }
    public SimpleLongProperty idProperty () {
        return id;
    }
    public void setId (long id) {
        this.id.set(id);
    }
    public String getName () {
        return name.get();
    }
    public SimpleStringProperty nameProperty () {
        return name;
    }
    public void setName (String name) {
        this.name.set(name);
    }
    @Override
    public String toString () {
        return
                name.get() ;

    }

    public void setTypeName (String typeName) {
        this.name.set(typeName);
    }


    public String getTypeName () {
        return name.get();
    }


    public String getStr (String type_name) {
        return null;
    }

    public long getId () {
        return this.id.get();
    }
}
