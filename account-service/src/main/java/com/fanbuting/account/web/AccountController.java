package com.fanbuting.account.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fanbuting.account.entity.Account;
import com.fanbuting.account.service.AccountService;
import com.fanbuting.account.service.AccountService2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@RestController
//@RequestMapping(value="/account"),这里也可以增加地址前缀
public class AccountController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;
    
    @Autowired
    AccountService2 accountService2;
    
    
    /*
     * 这个是发布接口最复杂的场景。
     * 请求是复杂对象，返回也是复杂对象
     * 
     * 对应的请求地址:http://localhost:8763/update
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
    	
    	//System.out.println("request is " + account.toString());
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
    

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }
    
    @RequestMapping(value = "/xxxx", method = RequestMethod.GET)
    public String getAccounts1() {
        return "x1";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t= accountService.update(name,money,id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        int t= accountService.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

       int t= accountService.add(name,money);
       if(t==1) {
           return "success";
       }else {
           return "fail";
       }

    }


}