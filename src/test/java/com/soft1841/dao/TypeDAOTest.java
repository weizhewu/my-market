package com.soft1841.dao;

import cn.hutool.db.Entity;
import com.soft1841.entity.Type;
import com.soft1841.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TypeDAOTest {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

//    新增图书测试
    @Test
    public void insertType() throws SQLException{
        Type type = new Type();
        type.setTypeId(10);
        type.setTypeName("测试");
        System.out.println(typeDAO.insertType(type));
    }

//    根据id删除测试
    @Test
    public void deleteType() throws SQLException{
        typeDAO.deleteType(11);
    }

//    查询所有类别测试
    @Test
    public void selectAllTypes()throws SQLException{
        List<Entity> typesList = typeDAO.selectAllTypes();
        System.out.println(typesList);
    }

//    根据id查询测试
    @Test
    public void getTypeById()throws SQLException{
        Entity entity = typeDAO.getTypeById(3);
        System.out.println(entity);
    }


}