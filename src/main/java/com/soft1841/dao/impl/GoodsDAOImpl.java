package com.soft1841.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.dao.GoodsDAO;
import com.soft1841.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public  class GoodsDAOImpl implements GoodsDAO {
    @Override
    public List<Object> insertGoods(Goods goods) throws SQLException {
        return Db.use().insertForGeneratedKeys(
                Entity.create("t_goods")
                        .set("name", goods.getName())
                        .set("id",goods.getId())
                        .set("price",goods.getPrice())
                        .set("picture",goods.getPicture())
                        .set("stock",goods.getStock())
                        .set("discription",goods.getDiscription())
                        .set("type_id",goods.getType_id())
        );
    }

//删除
    @Override
    public int deleteGoodsById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("id", id)
        );
    }
//只是修改了商品的名字和价格
    @Override
    public int updateGoods(Goods goods) throws SQLException {
        return Db.use().update(
                Entity.create().set("name", goods.getName())
                        .set("price",goods.getPrice()),
                Entity.create("t_goods").set("id", goods.getId())
        );
    }

    @Override
    public List<Entity> selectAllGoods() throws SQLException {
        return Db.use().query("SELECT * FROM t_goods");
    }


    @Override
    public Entity getGoodById(long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_goods WHERE id = ? ", id);
    }


    @Override
    public List<Entity> selectGoodsLike(String keywords) throws SQLException {
        return Db.use().query("SELECT * FROM t_goods ");
    }

    @Override
    public List<Entity> selectGoodsByTypeId(long typeId) throws SQLException {
        return Db.use().query("SELECT * FROM t_goods WHERE type_id = ?",typeId);
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_goods WHERE type_id = ? ", typeId).intValue();
    }



}
