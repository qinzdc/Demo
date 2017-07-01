package com.fanbuting.auth.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fanbuting.account.entity.Account;
import com.fanbuting.auth.service.AccountService2;


@RestController
@RequestMapping(value="/auth")
public class AuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	/*
	 * 这个使用mysql配置文件调用mysql
	 */
    @Autowired
    AccountService2 accountService2;
    
    
    /*
     * 这个是发布接口最复杂的场景。
     * 请求是复杂对象，返回也是复杂对象
     * 
     * 对应的请求地址:http://localhost:8763/auth/update
     *   post
     *   application/json; charset=UTF-8
     *   body: {"id":1,"name":"aaa","money":1000.0}
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<Account> updateAccount(@RequestBody Account account)
    {
    	if (null == account)
    	{
    		LOG.info("input null");
    		return null;
    	}
    	
    	LOG.info("request is " + account.toString());
    	
    	accountService2.update(account.getMoney(), account.getId());
    	
    	Account rA = new Account();
    	rA.setId(account.getId());
    	rA.setMoney(account.getMoney());
    	rA.setName(account.getName());
    	
    	Account xx = new Account(100,"testAccount", 100);
    	
    	List<Account> rL = new ArrayList<>();
    	rL.add(rA);
    	rL.add(xx);
    	LOG.info("resp is " + rL.toString());
    	return rL;
    }
}