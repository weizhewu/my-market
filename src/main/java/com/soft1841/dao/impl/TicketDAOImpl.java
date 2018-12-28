package com.soft1841.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.dao.TicketDAO;
import com.soft1841.entity.Ticket;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    @Override
    public int deleteTicketById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_ticket").set("id", id)
        );
    }

    @Override
    public Long insertTicket(Ticket ticket) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_ticket")
                        .set("id", ticket.getTicketId())
                        .set("vip_id",ticket.getVipId())
                        .set("barcode",ticket.getBarcode())
                        .set("cashier_id",ticket.getCashierId())
                        .set("number",ticket.getNumber())
                        .set("count",ticket.getCount())
        );
    }

    @Override
    public List<Entity> selectAllTicket() throws SQLException {
        return Db.use().query("SELECT * FROM t_ticket ");
    }

    @Override
    public Entity getTicketById(long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_ticket WHERE id = ? ", id);
    }

    @Override
    public Entity getTicketByDate(Date date) throws SQLException {
        return (Entity) Db.use().query("SELECT * FROM t_ticket WHERE date = ?",date);
    }

    @Override
    public Entity getTicketByDate(int date) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_ticket WHERE date= ? ", date);
    }

    @Override
    public List<Entity> getTicketByCashierId(long CashierId) throws SQLException {
        return Db.use().query("SELECT * FROM t_ticket WHERE cashier_id=?",CashierId);
    }

    @Override
    public List<Entity> getTicketByMemberId(long MemberId) throws SQLException {
        return Db.use().query("SELECT * FROM t_ticket WHERE vip_id=?",MemberId);
    }


}
