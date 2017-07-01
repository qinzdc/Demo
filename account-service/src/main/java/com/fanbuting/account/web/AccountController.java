package com.fanbuting.account.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanbuting.account.entity.Account;
import com.fanbuting.account.service.AccountService;


@RestController
@RequestMapping(value="/account")
public class AccountController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	//这个类演示了服务调用dao使用注解方式写sql，简单的sql语句可以使用这个方式。
    @Autowired
    AccountService accountService;
    
    /*使用注解链接mysql
     * 
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }
}