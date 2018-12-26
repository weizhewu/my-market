package com.soft1841.controller;

import cn.hutool.db.Entity;
import com.soft1841.dao.GoodsDAO;
import com.soft1841.utils.DAOFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GoodsController implements Initializable {
    @FXML
    private FlowPane goodsPane;

    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();
    List<Entity> goodsList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            goodsList = goodsDAO.selectAllGoods();
            System.out.println(goodsList.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showGoods(goodsList);
    }

    //通过循环遍历readerList集合，创建HBox来显示每个读者信息
    private void showGoods(List<Entity> goodsList) {
        ObservableList<Node> observableList = goodsPane.getChildren();
        goodsPane.getChildren().removeAll(observableList);
        for (Entity entity : goodsList) {
            HBox hBox = new HBox();
            hBox.setPrefSize(320, 280);
            hBox.setSpacing(10);
            hBox.setPadding(new Insets(10, 10, 10, 10));
            //创建左侧的垂直布局,用来放头像和角色
            VBox leftBox = new VBox();
            leftBox.setSpacing(30);
            leftBox.setPadding(new Insets(20, 10, 10, 10));
            leftBox.setAlignment(Pos.TOP_CENTER);
            ImageView avatarImg = new ImageView(new Image(entity.getStr("picture")));
            avatarImg.setFitWidth(80);
            avatarImg.setFitHeight(80);
            //给头像设置圆形效果
            Circle circle = new Circle();
            circle.setCenterX(40);
            circle.setCenterY(40);
            circle.setRadius(40);
            avatarImg.setClip(circle);
            leftBox.getChildren().add(avatarImg);
            VBox rightBox = new VBox();
            rightBox.setPadding(new Insets(20, 10, 10, 10));
            rightBox.setSpacing(25);
            rightBox.setAlignment(Pos.TOP_CENTER);
            Label idLabel = new Label(entity.getStr("id"));
            Label type_idLabel = new Label(entity.getStr("type_id"));
            Label nameLabel = new Label(entity.getStr("name"));
            Label priceLabel = new Label(entity.getStr("price"));
            Label stockLabel = new Label(entity.getStr("stock"));
            Label discriptionLabel = new Label(entity.getStr("discription"));
            Button delButton = new Button("删除");
            delButton.getStyleClass().addAll("orange-button");
            delButton.setPrefSize(80, 80);
            rightBox.getChildren().addAll(nameLabel, idLabel,type_idLabel,priceLabel,stockLabel,discriptionLabel, delButton);
            hBox.getChildren().add(leftBox);
            hBox.getChildren().add(rightBox);
            goodsPane.getChildren().add(hBox);
            delButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setHeaderText("请确认");
                alert.setContentText("确定要删除这行记录吗?");
                Optional<ButtonType> result = alert.showAndWait();
                //点击了确认按钮，执行删除操作，同时移除一行模型数据
                if (result.get() == ButtonType.OK) {
                    //点击删除按钮做的事件，得到这个人的ID
                    try {
                        long id = entity.getLong("id");
                        goodsDAO.deleteGoodsById(2);
                        //从流式面板移除当前这个人的数据
                        goodsPane.getChildren().remove(hBox);
                    } catch (SQLException e) {
                        System.err.println("删除有误");
                    }
                }
            });
        }
    }
}