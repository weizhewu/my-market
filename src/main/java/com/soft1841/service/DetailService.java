package com.soft1841.service;

import com.soft1841.dao.DetailDAO;
import com.soft1841.entity.Detail;

import java.util.Date;
import java.util.List;

public interface DetailService {
    /**
     * 查所有明细
     * @return
     */
    List<DetailDAO>selectAllDetail();

    /**
     * 增加明细
     * @param detail
     * @return
     */
    Long insertDetail(Detail detail);

    /**
     * 根据id查明细
     * @param id
     * @return
     */
    Detail getDetail(long id);

    /**
     * 根据日期查明细
     * @param date
     * @return
     */
    Date getDate(int date);


}
