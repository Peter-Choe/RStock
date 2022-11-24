package com.neo.stock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockVo {
	
	private String accountNum;
	
	private String stockCode;
	
	private String buySell;
	
	private int notPaidAmount;
	
	private int total_amount;
	
	private double avgPrice;
	
	private double curPrice;
	
	private String gainLoss;
	
	private String renewTime;
	
	private String userId;
	
}
