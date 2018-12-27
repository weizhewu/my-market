package com.soft1841.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Type {
    //以JavaFX属性绑定的形式，定义和数据表字段id和type_name对应的属性，注意命名规范
    private final SimpleLongProperty typeId = new SimpleLongProperty();
    private final SimpleStringProperty typeName = new SimpleStringProperty("");
    private long id;

    public Type() {
    }

    public Type(long TypeId, String TypeName) {
        setTypeId(TypeId);
        setTypeName(TypeName);
    }

    public long getTypeId() {
        return typeId.get();
    }

    public SimpleLongProperty TypeIdProperty() {return typeId;}

    public void setTypeId(long TypeId) {
        this.typeId.set(TypeId);
    }



    public String getTypeName() {
        return typeName.get();
    }

    public SimpleStringProperty TypeNameProperty() {
        return typeName;
    }

    public void setTypeName(String TypeName) {
        this.typeName.set(TypeName);
    }

    @Override
    public String toString() {
        return typeName.get();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
