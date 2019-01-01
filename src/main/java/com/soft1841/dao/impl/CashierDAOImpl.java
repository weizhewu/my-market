package com.soft1841.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.dao.CashierDAO;
import com.soft1841.entity.Cashier;

import java.sql.SQLException;
import java.util.List;

/**
 * 2018.12.24
 */
public class CashierDAOImpl implements CashierDAO {

    @Override
    public Cashier getCashierByNumber(String number) throws SQLException {
        Entity entity =  Db.use().queryOne("SELECT * FROM t_cashier WHERE number = ? ",number );
        return convertSeller(entity);
    }

    @Override
    public long inserCashier (Cashier cashier) throws SQLException {
        return 0;
    }

    @Override
    public List<Entity> selectAllCashiers() throws SQLException {
       return Db.use().query("SELECT * FROM t_goods ");
    }

    private Cashier convertSeller(Entity entity){
        Cashier cashier = new Cashier(entity.getLong("id"),
                entity.getStr("number"),
                entity.getStr("name"),
                entity.getStr("password"),
                entity.getStr("picture"));
        return cashier;
    }
}
