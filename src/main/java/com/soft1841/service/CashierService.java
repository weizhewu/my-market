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

    /**
     * 根据工号查询收银员
     * @return
     */
    Cashier getCashier(String number);
}
