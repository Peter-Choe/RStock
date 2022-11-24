package com.neo.stock.controller;



import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neo.stock.service.GoogleChartService;
import com.neo.stock.vo.StockVo;



@RestController
@RequestMapping("/gchart/*")
public class GoogleChartController {
	@Autowired GoogleChartService service;
	
	@RequestMapping("/dbchart")
    public ModelAndView chart2(ModelAndView mv) {
		
		mv.setViewName("/chart");
        return mv;
    }
	
    @RequestMapping("/amountList")
    public JSONObject get_JsonData() {
    	List<StockVo> items = service.chart_Select();
       
        JSONObject data = new JSONObject();
       
        JSONObject col1 = new JSONObject();
        JSONObject col2 = new JSONObject();
        
        JSONArray title = new JSONArray();
        col1.put("label","종목"); 
        col1.put("type", "string");
        col2.put("label", "총수량");
        col2.put("type", "number");
        
        title.add(col1);
        title.add(col2);
        
        data.put("cols", title);
       
        
        JSONArray body = new JSONArray(); 
        for (StockVo vo : items) { 
            JSONObject name = new JSONObject(); 
            name.put("v", vo.getStockCode()); 
            
            JSONObject amount = new JSONObject();
            amount.put("v", vo.getTotal_amount()); 
            
            JSONArray row = new JSONArray(); 
            row.add(name); 
            row.add(amount);
            
            JSONObject cell = new JSONObject(); 
            cell.put("c", row);
            body.add(cell);     
        }
        data.put("rows", body);
        
        return data;
    }

 

}
