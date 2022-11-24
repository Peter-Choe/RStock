package com.neo.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.stock.vo.StockVo;

import data.mybatis.mapper.StockMapper;

@Service
public class TableServiceImpl implements TableService{
	@Autowired StockMapper mapper;
	
	@Override
	public List<StockVo> tacp_Select() {
		return mapper.tacp_Select();
	}
	@Override
	public List<StockVo> list_Select() {
		return mapper.list_Select();
	}
}
