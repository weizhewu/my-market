package com.soft1841.dao;

import com.soft1841.entity.Cashier;
import com.soft1841.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

public class CashierDAOTest {
    private CashierDAO cashierDAO = DAOFactory.getCashierDAOInstance();
//    查询测试
    @Test
    public void getCashierByNumber() throws SQLException {
        Cashier entity = cashierDAO.getCashierByNumber("2624001");
        System.out.println(entity);
    }

    @Test
    public void selectAllCashiers() {
    }
}