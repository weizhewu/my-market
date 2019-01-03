package com.soft1841.controller;

import com.soft1841.dao.GoodsDAO;
import com.soft1841.dao.TypeDAO;
import com.soft1841.entity.Goods;
import com.soft1841.entity.Type;
import com.soft1841.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
public class AddGoodsController implements Initializable {
    private ObservableList<Goods> GoodsData = FXCollections.observableArrayList();
    public ObservableList<Goods> getBookData() {
        return GoodsData;
    }
    public void setGoodsData(ObservableList<Goods> GoodsData) {
        this.GoodsData = GoodsData;
    }
    @FXML
    private ComboBox<Type> goodsType;
    @FXML
    private TextField goodsName, goodsPrice,goodsPicture;
    @FXML
    private TextArea goodsDiscription;
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private GoodsDAO GoodsDAO = DAOFactory.getGoodsDAOInstance();
    private TypeDAO TypeDAO = DAOFactory.getTypeDAOInstance();
    private List <Type> entityList = null;
    private Long typeId;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            entityList = TypeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Type entity : entityList) {
            Type type = new Type();
            type.setTypeName(entity.getTypeName());
            typeData.add(type);
        }
        goodsType.setItems(typeData);
        goodsType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    typeId = newValue.getId();
                }
        );
    }
    public void addGoods() throws Exception {

        String name = goodsName.getText();
        String price = goodsPrice.getText();
        String picture = goodsPicture.getText();
        String discription = goodsDiscription.getText();
        System.out.println();
        Goods Goods = new Goods();
        Goods.setType_id(typeId);
        Goods.setName(name);
        Goods.setPrice(Double.parseDouble(price));
        Goods.setPicture(picture);
        Goods.setDiscription(discription);
        long id = GoodsDAO.insertGoods(Goods);
        this.getBookData().add(Goods);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增商品成功!");
        alert.showAndWait();
        Stage stage = (Stage) goodsName.getScene().getWindow();
        stage.close();
    }
}
