package com.lin.spring1.DAO;

import com.lin.spring1.model.UpmsUserEntity;
import com.lin.spring1.model.UpmsUserEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsUserMapper {
    long countByExample(UpmsUserEntityExample example);

    int deleteByExample(UpmsUserEntityExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UpmsUserEntity record);

    int insertSelective(UpmsUserEntity record);

    List<UpmsUserEntity> selectByExample(UpmsUserEntityExample example);

    UpmsUserEntity selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UpmsUserEntity record, @Param("example") UpmsUserEntityExample example);

    int updateByExample(@Param("record") UpmsUserEntity record, @Param("example") UpmsUserEntityExample example);

    int updateByPrimaryKeySelective(UpmsUserEntity record);

    int updateByPrimaryKey(UpmsUserEntity record);
}