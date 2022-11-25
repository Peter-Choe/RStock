package com.project.mystock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceChartVO {
	private String date;
	private double open;
	private double hight;
	private double low;
	private double close;
}
