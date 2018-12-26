package com.soft1841.controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 前台主界面控制器，主要功能跳转子界面
 * @author 岳凡
 * 2018.12.25
 */
public class FontMainController {
    //弹出收银界面
    public void showReceiptsStage() throws Exception{
        Stage ReceiptsStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/receipts.fxml"));
        BorderPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        ReceiptsController receiptsController = fxmlLoader.getController();
        ReceiptsStage.setTitle("前台收银");
        //界面最大化
        ReceiptsStage.setMaximized(true);
        //logo设置
        ReceiptsStage.getIcons().add(new Image("/img/logo.png"));
        ReceiptsStage.setScene(scene);
        ReceiptsStage.show();
    }

    //弹出vip注册界面
    public void vipRegistrationStage() throws Exception{
        Stage vipRegistrationStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/vipRegistration.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        VipRegistrationController vipRegistrationController = fxmlLoader.getController();
        vipRegistrationStage.setTitle("VIP注册");
        //界面最大化
        vipRegistrationStage.setMaximized(true);
        //logo设置
        vipRegistrationStage.getIcons().add(new Image("/img/logo.png"));
        vipRegistrationStage.setScene(scene);
        vipRegistrationStage.show();
    }

    //弹出账单查询界面
    public void billSelectStage() throws Exception{
        Stage billSelectStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/billSelect.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        BillSelectController billSelectController = fxmlLoader.getController();
        billSelectStage.setTitle("账单查询");
        //界面最大化
        billSelectStage.setMaximized(true);
        //logo设置
        billSelectStage.getIcons().add(new Image("/img/logo.png"));
        billSelectStage.setScene(scene);
        billSelectStage.show();
    }

    //弹出个人中心界面
    public void personalStage() throws Exception{
        Stage personalStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/personal.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        PersonalController personalController = fxmlLoader.getController();
        personalStage.setTitle("个人中心");
        //界面最大化
        personalStage.setMaximized(true);
        //logo设置
        personalStage.getIcons().add(new Image("/img/logo.png"));
        personalStage.setScene(scene);
        personalStage.show();
    }

}
