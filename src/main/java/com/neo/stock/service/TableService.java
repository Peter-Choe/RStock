package com.neo.stock.service;

import java.util.List;

import com.neo.stock.vo.StockVo;

public interface TableService {
	public List<StockVo> tacp_Select();
	public List<StockVo> list_Select();
}
