package com.fanbuting.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanbuting.account.dao.AccountMapper2;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@Service
public class AccountService2 {
	
    @Autowired
    private AccountMapper2 accountMapper;
    

    
    public int update(double money, int id) {
        return accountMapper.update(money, id);
    }
}