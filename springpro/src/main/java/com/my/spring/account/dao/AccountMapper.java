package com.my.spring.account.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my.spring.account.dto.AccountDto;
import com.my.spring.account.dto.ItemDto;

@Repository
public interface AccountMapper {
	public List<AccountDto>getAccountList();
	public List<ItemDto>getItemDataList();
	
}
