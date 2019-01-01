package com.soft1841.service;

import com.soft1841.dao.GoodsDAO;
import com.soft1841.entity.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 查询所有商品
     * @return
     */
    List<Goods>selectAllGoods();
    /**
     * 查询所有商品信息
     * @return List<Reader>
     */
    List<Goods> getAllGoods();

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
    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    void deleteGoods(long id);


}
