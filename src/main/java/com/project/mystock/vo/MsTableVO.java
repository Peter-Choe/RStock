package com.project.mystock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsTableVO {
	private String userId;
	private String accNum;
	private String itemCd;
	private int amount;
	private double currPrice;
}
