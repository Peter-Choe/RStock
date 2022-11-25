package com.my.spring.stockchart.dto;

import lombok.Data;

@Data
public class StockDto {

	private long x;
	private float open;
	private float high;
	private float low;
	private float close;
}
