package com.my.spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockItemDTO {
	private String total_amount;
	private String stock_code;
	private String cur_price;
	private String user_id;
}
