package com.my.spring.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
	private String account_num;
	private String stock_code;
	private String trade_type;
	private long outstanding_amount;
	private BigDecimal avg_price;
	private BigDecimal cur_price;
	private String valu_loss;
	private String update_time;
	private String user_id;
	
}
