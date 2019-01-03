package com.soft1841.service;

import com.soft1841.entity.Cashier;

import java.util.List;

public interface CashierService  {
    /**
     * @zhouguoqing
     * 登录功能
     * @param number
     * @param password
     * @return
     */
    boolean login(String number, String password);

    Long insertCashier(Cashier cashier);

    void deleteCashierById(long id);

    List<Cashier> selectAllCashier();

    Cashier getCashierById(long id);

    Cashier getCashierByNumber(String number);

    List<Cashier> selectCashierLike(String keywords);
}
