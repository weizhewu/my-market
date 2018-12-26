package com.soft1841.utils;

import com.soft1841.service.*;
import com.soft1841.service.impl.*;

public class ServiceFactory {
    public static CashierService getCashierServiceInstance () {
        return new CashierServiceImpl();
    }
    public static DetailService getDetailServiceInstance () {
        return (DetailService) new DetailServiceImpl();
    }
    public static GoodsService getGoodsServiceInstance () {
        return (GoodsService) new GoodsServiceImpl();
    }
    public static TicketService getTicketServiceInstance () {
        return (TicketService) new TicketServiceImpl();
    }
    public static TypeService getTypeServiceInstance () {
        return (TypeService) new TypeServiceImpl();
    }
    public static VIPService getVIPServiceInstance () {
        return (VIPService) new VIPServiceImpl();
    }

}