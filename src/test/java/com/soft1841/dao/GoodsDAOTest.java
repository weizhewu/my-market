package com.soft1841.dao;

import cn.hutool.db.Entity;
import com.soft1841.entity.Goods;
import com.soft1841.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @weizhewu
 * 商品测试
 */

public class GoodsDAOTest {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();

//    删除测试
    @Test
    public void deleteGoods() throws SQLException{
        goodsDAO.deleteGoodsById(67);
    }

//    增加测试
   @Test
   public void insertGoods() throws SQLException{
        Goods goods = new Goods();
        goods.setName("测试");
        goods.setId(64);
        goods.setPrice(20);
        goods.setPicture("https://img.alicdn.com/imgextra/i2/2844431906/TB26yFwAgmTBuNjy1XbXXaMrVXa_!!2844431906.jpg_60x60q90.jpg");
        goods.setStock(20);
        goods.setDiscription("测试");
        goods.setType_id(2);
        goodsDAO.insertGoods(goods);
   }

//    所有物品关键词查询测试
    @Test
    public void selectGoodsLike() throws SQLException {
        List<Entity> goodsList = goodsDAO.selectGoodsLike("");
        System.out.println(goodsList);
    }

//    修改测试
    @Test
    public void updateGoods() throws SQLException{
        Goods goods = new Goods();
        goods.setId(68);
        goods.setName("测试");
        goods.setPrice(30);
        goodsDAO.updateGoods(goods);
    }

//    按物品id查询测试
    @Test
    public void getGoodById() throws SQLException{
        Entity entity = goodsDAO.getGoodById(68);
        System.out.println(entity);
    }

//    根据物品type_id查询测试
    @Test
    public void selectGoodsByTypeId() throws SQLException{
        List<Entity> entity = goodsDAO.selectGoodsByTypeId(3);
        System.out.println(entity);
    }

//    各类别物品数量查询测试
    @Test
    public void countByType() throws SQLException{
        int entity = goodsDAO.countByType(2);
        System.out.println(entity);
    }
}