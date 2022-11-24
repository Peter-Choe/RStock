package com.neo.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.stock.vo.ChartVo;

import data.mybatis.mapper.StockMapper;

@Service
public class HighChartServiceImpl implements HighChartService{
	
	@Autowired StockMapper mapper;
	@Override
	public List<ChartVo> chartJson() {
		return mapper.chartJson();
	}
	
	
}
