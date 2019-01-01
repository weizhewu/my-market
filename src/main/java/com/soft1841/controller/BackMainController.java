package com.soft1841.controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import javax.jws.Oneway;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 后台主界面控制，主要实现卡片切换式效果
 * 2018.12.24
 */
public class BackMainController implements Initializable {
    @FXML
    private StackPane backMainContainer;
    @Override
    public void initialize (URL location, ResourceBundle resources) {

    }
    //显示默认主页数据
    public void listDefault() throws Exception {
        switchView("default.fxml");
    }

    public void frontDesk() throws Exception{
        switchView("frontDesk.fxml");
    }

    public void ListGoods() throws Exception{
        switchView("goods.fxml");
    }

    public void ListType() throws Exception{
        switchView("type.fxml");
    }

    public void returnGoods() throws Exception{
        switchView("returnGoods.fxml");
    }

    public void changeGoods() throws Exception{
        switchView("changeGoods.fxml");
    }

    public void ListCashier() throws Exception{
        switchView("cashiers.fxml");
    }

    public void ListVIP() throws Exception{
        switchView("VIP.fxml");
    }

    public void goodsStatistics() throws Exception{
        switchView("goodsStatistics.fxml");
    }

    public void turnover() throws Exception{
        switchView("turnover.fxml");
    }

    public void employeeEffectiveness() throws Exception{
        switchView("employEffect.fxml");
    }

    //封装一个切换视图的方法：用来根据fxml文件切换视图内容
    private void switchView(String fileName) throws Exception {
        //清除主面板之前内容
        ObservableList<Node> list = backMainContainer.getChildren();
        backMainContainer.getChildren().removeAll(list);
        //读取新的布局文件加入主面板
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        backMainContainer.getChildren().add(anchorPane);
    }
}
