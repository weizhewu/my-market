package com.soft1841.dao;

import cn.hutool.db.Entity;
import com.soft1841.entity.Cashier;

import java.sql.SQLException;
import java.util.List;

/**
 * @tianzhen
 * 2018.12.24
 * 收营员DAO接口
 */

public interface CashierDAO {
    /**
     * 根据工号查询收银员
     * @param number
     * @return
     * @throws SQLException
     */
   Cashier getCashierByNumber(String number) throws SQLException;

    long inserCashier(Cashier cashier) throws SQLException;

    List<Entity> selectAllCashiers() throws SQLException;
}
