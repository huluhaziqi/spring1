package com.lin.spring1.service;

import com.lin.spring1.DAO.OrderDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
public class OrderService2 {

    OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void addMoney2(){
        orderDao.addMoney();
        int i = 10 / 0;
        orderDao.reduceMoney();
    }
}
