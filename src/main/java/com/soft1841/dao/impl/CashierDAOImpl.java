package com.soft1841.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.dao.CashierDAO;
import com.soft1841.entity.Cashier;

import java.sql.SQLException;

/**
 * @tianzhen
 * 2018.12.24
 */
public class CashierDAOImpl implements CashierDAO {

    @Override
    public Cashier getCashierByNumber(String number) throws SQLException{
        Entity entity =  Db.use().queryOne("SELECT * FROM t_cashier WHERE number = ? ",number );
        return convertSeller(entity);
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
