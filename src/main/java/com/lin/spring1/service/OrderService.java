package com.lin.spring1.service;

import com.lin.spring1.DAO.OrderDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class OrderService {

    OrderDao orderDao;

    // 注入TransactionTemplate对象
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    public void addMoney() {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Object result = null;
                try {
                    orderDao.addMoney();
                    int i = 10 / 0;
                    orderDao.reduceMoney();
                } catch (Exception e) {
                    e.printStackTrace();
                    transactionStatus.setRollbackOnly();
                    result = false;
                    System.out.println("transfer error !!");
                }
                return result;
            }
        });
    }

    public void addMoney2(){
        orderDao.addMoney();
        int i = 10 / 0;
        orderDao.reduceMoney();
    }
}
