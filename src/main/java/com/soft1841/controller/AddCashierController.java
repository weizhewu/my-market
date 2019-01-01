package com.soft1841.controller;

import com.soft1841.dao.CashierDAO;
import com.soft1841.entity.Cashier;
import com.soft1841.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.text.html.parser.Entity;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AddCashierController implements Initializable {
    private ObservableList<Cashier> cashierData = FXCollections.observableArrayList();
    private String title;

    public ObservableList<Cashier> getCashierData() {return cashierData;}

    public void setCashierData(ObservableList<Cashier> cashierData) {this.cashierData = cashierData;}

    @FXML
    private TextField cashierName,cashierNumber,cashierPassword;
    private CashierDAO cashierDAO = DAOFactory.getCashierDAOInstance();
    private List<Entity> entityList = null;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCashier();
        } catch (Exception e) {
            System.err.println("增加失败");
        }

    }
    public void addCashier() throws SQLException {
        String name = cashierName.getText();
        String number = cashierNumber.getText();
        String password = cashierPassword.getText();
        Cashier cashier = new Cashier();
        cashier.setName(name);
        cashier.setNumber(number);
        cashier.setPassword(password);


        long id = cashierDAO.inserCashier(cashier);
        cashier.setId(id);
        this.getCashierData().add(cashier);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增收银员成功");
        alert.showAndWait();
        Stage stage = (Stage) cashierName.getScene().getWindow();

        stage.close();
    }


    public void setTitle(String title) {
        this.title = title;
    }

}
