package com.soft1841.service;

import com.soft1841.dao.GoodsDAO;
import com.soft1841.entity.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 查询所有商品
     * @return
     */
    List<GoodsDAO>selectAllGoods();

    /**
     * 增加商品
     * @param goods
     * @return
     */
    Long insertGoods(Goods goods);

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    Goods getGoodById(long id);


}
