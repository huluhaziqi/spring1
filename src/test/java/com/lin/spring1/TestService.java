package com.lin.spring1;


import com.lin.spring1.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-properties.xml"})
public class TestService {

    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("test.xml","applicationContext-properties.xml");
        OrderService orderService = (OrderService) context.getBean("ordersService");
        orderService.addMoney();
    }
}
