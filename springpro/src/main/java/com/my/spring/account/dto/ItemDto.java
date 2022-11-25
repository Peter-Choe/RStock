package com.my.spring.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	
	private String item_code;
	private int total_amount;
	private double cur_price;
	private String update_time;
}
