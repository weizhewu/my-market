package com.soft1841.service.impl;
import cn.hutool.db.Entity;
import com.soft1841.dao.TypeDAO;
import com.soft1841.entity.Type;
import com.soft1841.service.TypeService;
import com.soft1841.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018.12.25
 * 分类显示业务逻辑层的实现
 */
public class TypeServiceImpl implements TypeService {
    private TypeDAO typeDAO = (TypeDAO) DAOFactory.getTypeDAOInstance();

    @Override
   public List<Entity> getAllTypes(){
       List<Entity> typeList = new ArrayList<>();
       try {
           typeList = typeDAO.selectAllTypes();
       }catch (SQLException e){
           System.err.println("查询所有类别出现异常");
       }
       return typeList;
   }

    @Override
    public Type getType (long id) {
        Type type = new Type();
        try {
            type = typeDAO.getTypeById(id);
        } catch (SQLException e) {
            System.err.println("查询单个类别出现异常!");
        }
        return type;
    }

    @Override
    public Long addType (Type type) {
        long result = 0;
        try {
            //调用底层DAO的查询新增类别方法，薄层封装，返回自增主键
            result = typeDAO.insertType(type);
        } catch (SQLException e) {
            System.err.println("新增类别出现异常!");
        }
        return result;
    }
    @Override
    public void deleteType (long id) {
        try {
            //调用底层DAO的查询删除类别方法，薄层封装
            typeDAO.deleteTypeById(id);
        } catch (SQLException e) {
            System.err.println("删除类别出现异常!");
        }
    }
}
