package com.soft1841.controller;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private ImageView goodImg;
    //轮播图资源数组
    String[] imgPath = {"1.png","3.png","5.png","8.png","10.png"};
    @Override
    public void initialize (URL location, ResourceBundle resources) {

        //新建一个线程，用来轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //循环读取图片数组
                    for (int i = 0; i < imgPath.length; i++) {
                        //用每个资源创建一个图片对象
                        Image image = new Image("/img/" + imgPath[i]);
                        //开启一个UI线程
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //将创建的Image对象设置给ImageView
                                goodImg.setImage(image);
                            }
                        });
                        try {
                            //休眠2秒
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //轮播到最后一张图的时候，回到第一张重新播放
                        if (i == imgPath.length - 1) {
                            i = 0;
                        }
                    }
                }
            }
        }).start();

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
