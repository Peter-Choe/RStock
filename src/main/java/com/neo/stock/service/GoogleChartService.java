package com.neo.stock.service;

import java.util.List;

import com.neo.stock.vo.StockVo;

public interface GoogleChartService {
	public List<StockVo> chart_Select();
}
