package com.lin.spring1;

import com.lin.spring1.model.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:applicationContext-properties.xml"})
public class MybatisTest {

    @Test
    public void testAdd() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext-properties.xml");
//        OrderService orderService = (OrderService) context.getBean("ordersService");
//        orderService.addMoney();
        DefaultSqlSessionFactory defaultSqlSessionFactory = (DefaultSqlSessionFactory)context.getBean("ecoSqlSessionFactory");
        SqlSession sqlSession = defaultSqlSessionFactory.openSession();

        List<Account> list =  sqlSession.selectList("com.lin.spring1.DAO.AccountMapper.selectByPrimaryKey",1);
        System.out.println(list);
    }
}