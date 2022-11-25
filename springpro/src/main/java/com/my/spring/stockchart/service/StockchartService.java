package com.my.spring.stockchart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my.spring.stockchart.dto.StockDto;


public interface StockchartService {

	public List<StockDto>getStockData();
}
