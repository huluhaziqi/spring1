package com.lin.spring1.DAO;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void reduceMoney() {
        String sql = "update account set salary = salary - ? where username = ?";
        jdbcTemplate.update(sql, new Object[]{1000, "小王"},new int[]{Types.INTEGER, Types.VARCHAR});
    }

    public void addMoney(){
                String sql = "update account set salary = salary + ? where username = ?";
        jdbcTemplate.update(sql, new Object[]{1000, "小马"},new int[]{Types.INTEGER, Types.VARCHAR});
    }
}
