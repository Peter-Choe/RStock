package com.my.spring.stockchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.stockchart.dao.StockchartMapper;
import com.my.spring.stockchart.dto.StockDto;

@Service
public class StockchartServiceImpl implements StockchartService{

	@Autowired
	private StockchartMapper stockChartMapper;
	
	@Override
	public List<StockDto> getStockData() {
		// TODO Auto-generated method stub
		return stockChartMapper.getStockData();
	}
}
