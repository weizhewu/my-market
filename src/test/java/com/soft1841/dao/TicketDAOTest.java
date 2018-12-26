package com.soft1841.dao;

import cn.hutool.db.Entity;
import com.soft1841.entity.Ticket;
import com.soft1841.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class TicketDAOTest {
    private TicketDAO ticketDAO = DAOFactory.getTicketDAOInstance();

//    删除测试
    @Test
    public void deleteTicketById() throws SQLException {
    ticketDAO.deleteTicketById(10);
    }

//    增加测试(时间无法输入)
    @Test
    public void insertTicket() throws SQLException{
        Ticket ticket = new Ticket();
        ticket.setCashierId(1);
        ticket.setTicketId(17);
        ticket.setCount(554);
        ticket.setVipId(1213);
        ticket.setBarcode(3153);
        ticket.setNumber(12);
        ticket.setDate(String.valueOf(2018-12-12));
        System.out.println(ticketDAO.insertTicket(ticket));
    }

//    查询测试
    @Test
    public void selectAllTicket() throws SQLException {
    List<Entity> ticketList = ticketDAO.selectAllTicket();
        System.out.println(ticketList);
}
//    根据id查询测试
    @Test
    public void getTicketById()throws SQLException{
        Entity entity = ticketDAO.getTicketById(1);
        System.out.println(entity);
    }

//   根据日期查询测试
    @Test
    public void getTicketByDate()throws SQLException{
        Entity entity = ticketDAO.getTicketByDate(2018-12-05);
        System.out.println(entity);

    }
//    根据收银员id查询测试
    @Test
    public void getTicketByCashierId() throws SQLException{
        List<Entity> entity = ticketDAO.getTicketByCashierId(6);
        System.out.println(entity);
    }

//    根据会员id查询测试
    @Test
    public void getTicketByMemberId()throws SQLException{
        List<Entity> entity = ticketDAO.getTicketByMemberId(36424);
        System.out.println(entity);
    }
}

