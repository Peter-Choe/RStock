package com.my.spring.account.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.spring.account.dao.AccountMapper;
import com.my.spring.account.dto.AccountDto;
import com.my.spring.account.dto.ItemDto;
import com.my.spring.account.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping({"/account/chart", "/"})
	public String showAccountChart(Model model) {
		Map<String, Object> accountData = accountService.getAccountData();
		
		model.addAttribute("accountList",(List<AccountDto>)accountData.get("accountList"));
		model.addAttribute("itemList", (List<ItemDto>)accountData.get("itemList"));
		model.addAttribute("userIdList", accountData.get("userIdList"));
		
		System.out.println(accountData.get("accountList").toString());
		System.out.println(accountData.get("itemList").toString());
		return "jsp/accountChart";
	}
	
}
