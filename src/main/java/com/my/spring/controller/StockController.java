package com.my.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.spring.DTO.StockChartDTO;
import com.my.spring.DTO.StockDTO;
import com.my.spring.DTO.StockItemDTO;
import com.my.spring.stockService.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService service;
	
	@RequestMapping("/")
	public String listAccount(Model model, StockDTO stock) {
		List<StockDTO> listAccount = service.listAccount(stock);
		List<StockItemDTO> totalAccount = service.totalAccount(stock);
		
		for(StockDTO f : listAccount) {
			System.out.println(f.getOutstanding_amount());
		}
		
		Set<String> userIdSet = new HashSet<String>();
		for(StockDTO dto : listAccount) {
			userIdSet.add(dto.getUser_id());
		}
		
		Iterator<String> userId = userIdSet.iterator();
		List<String> userIdList = new ArrayList<String>();
		while(userId.hasNext()) {
			userIdList.add(userId.next());
		}
		Collections.sort(userIdList);
		
		model.addAttribute("userIdList",userIdList);
		model.addAttribute("accountList", listAccount);
		model.addAttribute("itemList", totalAccount);
		return "bodys/home";
	}
	
	@RequestMapping("/timeChart")
	public String timeChart(Model model) {
		return "bodys/timeChart";
	}
	

	@RequestMapping("/stockChart")
	public String stockChart(Model model) {
	
		return "bodys/stockChart";
	}
	
	@ResponseBody
	@RequestMapping("/getChartData")
	public List<StockChartDTO> getChartData(Model model) {
		List<StockChartDTO> chartData = service.stockChartData();
		for(StockChartDTO f : chartData) {
			System.out.println(f.getHigh());
		}
		
		return chartData;
	}
	
	
}

