package com.neo.stock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChartVo {
	private long x;
	private double o;
	private double h;
	private double l;
	private double c;
	private long volume;
}
