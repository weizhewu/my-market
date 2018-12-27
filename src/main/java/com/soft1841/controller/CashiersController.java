package com.soft1841.controller;

import cn.hutool.db.Entity;
import com.soft1841.dao.CashierDAO;
import com.soft1841.entity.Cashier;
import com.soft1841.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CashiersController implements Initializable {
    //布局文件中的表格视图对象，用来显示数据库中读取的所有收银员信息
    @FXML
    private TableView<Cashier> cashierTable;
    private ObservableList<Cashier> cashierData;
    List<Entity> cashierList = null;
    private CashierDAO cashierDAO = DAOFactory.getCashierDAOInstance();
    private ObservableList<Cashier> cashiersData = FXCollections.observableArrayList();
    @FXML
    private TextField keywordsField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void newcashierStage() throws Exception {
        Stage addCashierStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_cashier.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        AddCashierController addCashierController = fxmlLoader.getController();
        addCashierController.setCashierData(cashierData);
        addCashierController.setTitle("新增收银员界面");
        addCashierStage.setResizable(false);
        addCashierStage.setScene(scene);
        addCashierStage.show();
    }




}

