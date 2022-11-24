package com.my.spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockChartDTO {

	private long x;
	private float open;
	private float high;
	private float low;
	private float close;
	
	
}
