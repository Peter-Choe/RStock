package com.my.spring.account.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.account.dao.AccountMapper;
import com.my.spring.account.dto.AccountDto;
import com.my.spring.account.dto.ItemDto;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper mapper;
	
	@Override
	public Map<String, Object> getAccountData() {
		List<AccountDto> accountList = mapper.getAccountList();
		List<ItemDto> itemList = mapper.getItemDataList();
		Map<String, Object>accountData = new HashMap<String, Object>();
		
		Set<String> userIdSet = new HashSet<>();  
		
		for(AccountDto dto : accountList) {
			userIdSet.add(dto.getUser_id());
		}
		
		Iterator<String>userIditor = userIdSet.iterator();
		List<String>userIdList	= new ArrayList<>();

		while (userIditor.hasNext()) {
			userIdList.add(userIditor.next());
		}
		
		Collections.sort(userIdList);
		accountData.put("accountList", accountList);
		accountData.put("itemList", itemList);
		accountData.put("userIdList", userIdList);
		
		return accountData;
	}

}
