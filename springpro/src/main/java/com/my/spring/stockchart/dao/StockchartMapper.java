package com.my.spring.stockchart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my.spring.stockchart.dto.StockDto;

@Repository
public interface StockchartMapper {
	public List<StockDto>getStockData();
}
