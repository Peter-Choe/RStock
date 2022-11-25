package com.my.spring.account.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.my.spring.account.dto.AccountDto;

@Service
public interface AccountService {
	public Map<String, Object>getAccountData();
}
