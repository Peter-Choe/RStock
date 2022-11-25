package com.my.spring.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private String account_num;
	private String item_code;
	private String type;
	private int outstand_amount;
	private double avg_price;
	private double cur_price;
	private String val_pl;
	private String update_time;
	private String user_id;
	
}
