package com.soft1841.controller;
import com.soft1841.entity.Cashier;
import com.soft1841.service.CashierService;
import com.soft1841.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class CashiersController implements Initializable {
    @FXML
    private ListView cashierListView;
    private CashierService cashierService = ServiceFactory.getCashierServiceInstance();
    private List<Cashier> cashierList = new ArrayList<>();
    private ObservableList<Cashier> observableList = FXCollections.observableArrayList();
    private static final int MAX_THREADS = 4;
    //线程池配置
    private final Executor executor = Executors.newFixedThreadPool(MAX_THREADS,runnable -> {
        Thread t = new Thread(runnable);
        t.setDaemon(true);
        return t;
    });
    @Override
    public void initialize (URL location, ResourceBundle resources) {
        cashierList = cashierService.selectAllCashier();
        observableList.setAll(cashierList);
        cashierListView.setItems(observableList);
        cashierListView.setCellFactory(new Callback<ListView<Cashier>, ListCell<Cashier>>() {
            @Override
            public ListCell<Cashier> call(ListView<Cashier> param) {
                return new ListCell<Cashier>(){
                    @Override
                    public void updateItem(Cashier item, boolean empty){
                        super.updateItem(item,empty);
                        if (item != null && !empty){
                            HBox container = new HBox();
                            container.setSpacing(20);
                            container.setMouseTransparent(true);
                            ImageView imageView = new ImageView();
                            //利用线程池来加载图片，并设置为收银员头像
                            executor.execute(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImage(new Image(item.getAvatar()));
                                }
                            });
                            imageView.setFitWidth(50);
                            imageView.setFitHeight(50);
                            Label nameLabel = new Label(item.getName());
                            Label numberLabel = new Label(item.getNumber());
                            container.getChildren().addAll(imageView,nameLabel,numberLabel);
                            setGraphic(container);
                        }
                    }
                };
            }
        });

    }


    //新增收银员方法
    public void insertCashier() {
        //创建一个Cashier对象
        Cashier cashier = new Cashier();
        //新建一个舞台
        Stage stage = new Stage();
        stage.setTitle("新增收银员界面");
        //创建一个处置布局，用来放新增用户的各个组件
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        Label infoLabel = new Label("请输入收银员信息");
        infoLabel.setPrefHeight(50);
        infoLabel.setPrefWidth(580);
        infoLabel.setAlignment(Pos.CENTER);
        //给文本添加样式
        TextField nameField = new TextField();
        nameField.setPromptText("请输入姓名");
        //输入框无焦点
        nameField.setFocusTraversable(false);
        TextField pictureField = new TextField();
        pictureField.setPromptText("请输入头像地址");
        pictureField.setFocusTraversable(false);
        //账号输入框
        TextField numberField = new TextField();
        numberField.setPromptText("请输入账号");
        numberField.setFocusTraversable(false);
        //密码输入框
        TextField passwordField = new TextField();
        passwordField.setPromptText("请输入密码");
        passwordField.setFocusTraversable(false);
        //新增按钮
        FlowPane flowPane = new FlowPane();
        Button addBtn = new Button("新增");
        addBtn.setPrefWidth(120);
        flowPane.getChildren().add(addBtn);
        flowPane.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(      infoLabel, nameField,
                numberField, passwordField, pictureField, flowPane);
        Scene scene = new Scene(vBox, 450, 380);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();
        //点击新增按钮，将界面数据封装成一个Cashier对象，写入数据库
        addBtn.setOnAction(event -> {
            String nameString = nameField.getText().trim();
            String pictureString = pictureField.getText().trim();
            String numberString = numberField.getText().trim();
            String passwordString = passwordField.getText().trim();
            cashier.setName(nameString);
            cashier.setAvatar(pictureString);
            cashier.setNumber(numberString);
            cashier.setPassword(passwordString);
            System.out.println(cashier.getName() +cashier.getNumber()+cashier.getPassword()+ cashier.getAvatar());
            cashierService.insertCashier(cashier);
            stage.close();
            //重新读取一下数据显示
            cashierList = cashierService.selectAllCashier();
            showCashier(cashierList);
        });
    }

    private void showCashier(List<Cashier> cashierList) {
    }
}

