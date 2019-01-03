package com.soft1841.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.dao.CashierDAO;
import com.soft1841.entity.Cashier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @tianzhen
 * 2018.12.24
 */
public class CashierDAOImpl implements CashierDAO {

    @Override
    public Cashier getCashierByNumber(String number) throws SQLException {
        Entity entity =  Db.use().queryOne("SELECT * FROM t_cashier WHERE number = ? ",number );
        return convertCashier(entity);
    }

    @Override
    public Cashier getCashierById(long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_cashier WHERE id = ?", id);
        return convertCashier(entity);
    }

    @Override
    public List<Cashier> selectAllCashier() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_cashier");
        List<Cashier> cashierList = new ArrayList<>();
        for (Entity entity:entityList) {
            cashierList.add(convertCashier(entity));
        }
        return cashierList;
    }

    @Override
    public Long insertCashier(Cashier cashier) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_cashier")
                        .set("name", cashier.getName())
                        .set("password", cashier.getPassword())
                        .set("picture",cashier.getAvatar())
                        .set("number",cashier.getNumber())
        );
    }

    @Override
    public int deleteCashierById(long id) throws SQLException {
        return Db.use().del(
                cn.hutool.db.Entity.create("t_cashier").set("id", id)
        );
    }

    @Override
    public List<Cashier> selectLikeName(String keywords) throws SQLException {
        List<Entity> entityList = Db.use().findLike("t_cashier", "name", keywords, Condition.LikeType.Contains);
        List<Cashier> cashierList = new ArrayList<>();
        for (Entity entity : entityList) {
            cashierList.add(convertCashier(entity));
        }
        return cashierList;
    }

    private Cashier convertCashier(Entity entity){
        Cashier cashier = new Cashier(entity.getLong("id"),
                entity.getStr("number"),
                entity.getStr("name"),
                entity.getStr("password"),
                entity.getStr("picture"));
        return cashier;
    }
}
