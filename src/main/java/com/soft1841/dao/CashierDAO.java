package com.soft1841.dao;

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
    Cashier getCashierByNumber(String number)throws SQLException;

    Cashier getCashierById(long id) throws SQLException;

    /**
     * 查所有
     * @param
     * @return
     * @throws SQLException
     */
    List<Cashier> selectAllCashier() throws SQLException;

    /**
     * 增加cashier
     * @param cashier
     * @return
     * @throws SQLException
     */

    Long insertCashier(Cashier cashier) throws SQLException;

    /**
     * 删除收银员
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteCashierById(long id) throws SQLException;

    /**
     * 关键词查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Cashier> selectLikeName(String keywords) throws SQLException;


}
