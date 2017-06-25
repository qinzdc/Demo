package com.fanbuting.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@Mapper
public interface AccountMapper2
{
	   int update( @Param("money") double money, @Param("id") int  id);
}