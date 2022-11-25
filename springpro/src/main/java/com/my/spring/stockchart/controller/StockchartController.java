package com.my.spring.stockchart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.spring.stockchart.dto.StockDto;
import com.my.spring.stockchart.service.StockchartService;

@Controller
public class StockchartController {

	@Autowired
	private StockchartService stockChartService;
	
	@GetMapping("/stock/chart")
	public String stockchart() {
		return "jsp/stockchart";
	}
	
	@GetMapping("/stock/data")
	public @ResponseBody ResponseEntity<List<StockDto>> getData(){
		List<StockDto> stockData = stockChartService.getStockData();
		return new ResponseEntity<List<StockDto>>(stockData, HttpStatus.OK);
		
	}
	
}
