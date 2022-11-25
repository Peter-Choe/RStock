package com.project.mystock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.mystock.service.MsService;
import com.project.mystock.vo.MsTableVO;

@Controller
public class MsController {
	
	@Autowired
	private MsService msService;
	
	
	@RequestMapping(value = {"/", "/portfolio"})
	public String showTable(Model model) {
		List<String> userIdList = msService.getUserIdList();
		model.addAttribute("userIdList", userIdList);
		List<String> accNumList = msService.getAccNumList();
		model.addAttribute("accNumList",accNumList);
		List<HashMap<String, String>> itemList = msService.getItemList();
		model.addAttribute("itemList", itemList);
		List<String> accountList = msService.getAccountList();
		model.addAttribute("accountList", accountList);
		model.addAttribute("today", getToday()); // 필터나 다른 방법으로 개선
		return "table";
	}
	
	

	
	
	@RequestMapping("/chart")
	public String showChart(Model model) {
		//정적 차트 데이터
		JSONArray priceJA = msService.getPriceList();
		model.addAttribute("priceJA", priceJA);
//		msService.addCurrPrice();
		model.addAttribute("today", getToday());
		return "chart";
	}
	
	@RequestMapping(value="/data", method = {RequestMethod.GET})
	public void getCurrPrice(HttpServletRequest req, HttpServletResponse resp) {
		String currPrice = msService.getCurrPrice();
//		System.out.println(currPrice);
		PrintWriter writer = null;
		try {
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			
			writer = resp.getWriter();
			writer.print(currPrice);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	
	private String getToday() {
		LocalDate now = LocalDate.now();
		String today = now.toString();
		
		return today;
	}
}
