package com.lin.spring1.DAO;

import com.lin.spring1.model.Account;
import com.lin.spring1.model.AccountExample;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);
}