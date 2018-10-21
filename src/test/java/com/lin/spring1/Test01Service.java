package com.lin.spring1;


import com.lin.spring1.service.OrderService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class Test01Service {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("test1.xml","applicationContext-properties.xml");
        OrderService2 orderService = (OrderService2) context.getBean("ordersService2");
        orderService.addMoney2();
    }
}
