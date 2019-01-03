package com.soft1841.service.impl;


import com.soft1841.dao.CashierDAO;
import com.soft1841.entity.Cashier;
import com.soft1841.entity.VIP;
import com.soft1841.service.CashierService;
import com.soft1841.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @zhouguoqing
 * 2018.12.24
 */
public class CashierServiceImpl  implements CashierService {
    private CashierDAO cashierDAO = DAOFactory.getCashierDAOInstance();

    @Override
    public boolean login(String number, String password) {
        Cashier cashier = null;
        try {
            cashier = cashierDAO.getCashierByNumber(number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据工号查找成功
        if (cashier != null) {
            //比较密码
            if (password.equals(cashier.getPassword())) {
                return true;
            }
        }
        return false;

    }

    @Override
    public Long insertCashier(Cashier cashier) {
        long result = 0;
        try {
            result = cashierDAO.insertCashier(cashier);
        }catch (SQLException e){
            System.err.println("增加异常");
        }
        return result;
    }

    @Override
    public void deleteCashierById(long id) {
        try {
            cashierDAO.deleteCashierById(id);
        }catch (SQLException e){
            System.err.println("删除异常");
        }
    }

    @Override
    public List<Cashier> selectAllCashier() {
        List<Cashier> cashierList = new ArrayList<>();
        try {
            cashierList = cashierDAO.selectAllCashier();
        }catch (SQLException e){
            System.err.println("查询VIP异常");
        }
        return cashierList;
    }

    @Override
    public Cashier getCashierById(long id) {
        Cashier cashier = new Cashier();
        try {
            cashier = cashierDAO.getCashierById((int) id);
        }catch (SQLException e){
            System.err.println("根据id查询单个异常");
        }
        return cashier;
    }

    @Override
    public Cashier getCashierByNumber(String number) {
        Cashier cashier = new Cashier();
        try {
            cashier = cashierDAO.getCashierByNumber(number);
        }catch (SQLException e){
            System.err.println("根据number查询单个异常");
        }
        return cashier;
    }

    @Override
    public List<Cashier> selectCashierLike(String keywords) {
        List<Cashier> cashierList = new ArrayList<>();
        try {
            cashierList = cashierDAO.selectLikeName(keywords);
        }catch (SQLException e){
            System.err.println("查询VIP异常");
        }
        return cashierList;
    }
}
