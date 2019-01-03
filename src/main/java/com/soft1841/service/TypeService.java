package com.soft1841.service;

import com.soft1841.entity.Type;

import java.util.List;

/**
 * 2018.12.25
 */
public interface TypeService {
    /**
     * 获取所有图书类别的功能
     * @return
     */
    List <Type> getAllTypes();

    /**
     * 根据id查询类别
     * @param id
     * @return
     */
    Type getType(long id);

    /**
     * 添加类别
     * @param type
     */
    Long addType(Type type);

    /**
     * 删除类别
     * @param id
     */
    void deleteType(long id);
}
