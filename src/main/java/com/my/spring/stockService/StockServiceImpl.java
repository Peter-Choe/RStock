package com.my.spring.stockService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.spring.DAO.StockDAO;
import com.my.spring.DTO.StockChartDTO;
import com.my.spring.DTO.StockDTO;
import com.my.spring.DTO.StockItemDTO;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockDAO dao;
	
	@Override
	public List<StockDTO> listAccount(StockDTO stock) {
		return dao.listAccount(stock);
	}

	@Override
	public List<StockItemDTO> totalAccount(StockDTO stock) {
		// TODO Auto-generated method stub
		return dao.totalAccount(stock);
	}

	@Override
	public List<StockChartDTO> stockChartData() {
		
		return dao.chartJson();
	}



}
