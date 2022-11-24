package com.neo.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.stock.vo.StockVo;

import data.mybatis.mapper.StockMapper;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {
	
	@Autowired StockMapper mapper; 
	@Override
	public List<StockVo> chart_Select() {
		return mapper.chart_Select();
	}
}
